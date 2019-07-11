package moe.kasugano.logic;

public class MarkCommand extends Command {
    
    int index;
    
    public MarkCommand(int index){
        this.index = index;
    }
    
    @Override
    String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task t = tasks.markAsDone(index);
        storage.save(tasks.list());
        return ui.showMarkAsDone(t);
    }
}
