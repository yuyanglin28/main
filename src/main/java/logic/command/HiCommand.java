package logic.command;

import tasks.Task;

public class HiCommand extends Command {
    private Task task;
    public static final String COMMAND_WORD = "hi";

    @Override
    public CommandOutput execute() {
        return new CommandOutput("This is the hello message");
    }
}
