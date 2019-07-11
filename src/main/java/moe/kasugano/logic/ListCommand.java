package moe.kasugano.logic;

public class ListCommand extends Command {
    
    
    @Override
    String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.showTaskList(tasks.getTaskListDescriptions());
    }

}
