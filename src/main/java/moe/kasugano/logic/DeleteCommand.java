package moe.kasugano.logic;

public class DeleteCommand extends Command {
    
    int index;
    
    public DeleteCommand(int index){
        this.index = index;
    }
    
    @Override
    String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task t = tasks.delete(index);
        storage.save(tasks.list());
        return ui.showDeletion(t);
    }
}
