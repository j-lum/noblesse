package moe.kasugano.logic;

public class AddCommand extends Command {
    
    Task task;
    
    public AddCommand(Task task){
        this.task = task;
    }
    
    @Override
    String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.addTask(task);
        storage.save(tasks.list());
        return ui.showAddition(task) + "\n" +  ui.showListSize(tasks.size());
    }
}
