package moe.kasugano.logic;


public class Parser {
    
    public static Command parse(String line) throws DukeException {
        String commandWord = Parser.getCommandWord(line);
        switch (commandWord) {
            case "bye":
                return new ExitCommand();
            case "todo":
                return new AddCommand(createTodo(line));
            case "deadline":
                return new AddCommand(createDeadline(line));
            case "delete":
                return new DeleteCommand(getIndex(line));
            case "event":
                return new AddCommand(createEvent(line));
            case "list":
                return new ListCommand();
            case "done":
                return new MarkCommand(getIndex(line));
        }
        throw new DukeException(Ui.MESSAGE_UNKNOWN_COMMAND);
    }

    public static String getCommandWord(String line) {
        return line.strip().split(" ")[0];
    }

    public static Todo createTodo(String line) throws DukeException {
        String description = line.substring("todo".length()).strip();
        if (description.isEmpty()) {
            throw new DukeException("The description of a todo cannot be empty.");
        }
        return new Todo(description);
    }

    public static Deadline createDeadline(String line) {
        String[] deadlineDetails = line.substring("deadline".length()).strip().split("/by");
        return new Deadline(deadlineDetails[0].strip(), deadlineDetails[1].strip());
    }
    
    public static Event createEvent(String line) {
        String[] eventDetails = line.substring("event".length()).strip().split("/at");
        return new Event(eventDetails[0].strip(), eventDetails[1].strip());
    }

    public static int getIndex(String line) {
        String index = line.split(" ")[1].strip();
        return Integer.parseInt(index);
    }

    public static Task createTaskFromStorageLine(String line) {
        String[] taskParts = line.split("\\|");
        String type = taskParts[0].strip();
        String status = taskParts[1].strip();
        String description = taskParts[2].strip();
        Task t;
        if (type.equals("T")) {
            t = new Todo(description);
        } else if (type.equals("D")) {
            t = new Deadline(description, taskParts[3].strip());
        } else {
            t = new Event(description, taskParts[3].strip());
        }
        t.setDone(status.equals("1"));
        return t;
    }
}
