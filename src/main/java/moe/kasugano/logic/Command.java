package moe.kasugano.logic;

public abstract class Command {
    
    public boolean isExit(){
        return false;
    }
    
    abstract String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;
}
