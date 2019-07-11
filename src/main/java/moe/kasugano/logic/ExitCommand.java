package moe.kasugano.logic;

public class ExitCommand extends Command {
    
    
    @Override
    String execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        return ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
