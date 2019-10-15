package logic.command;


import tasks.Task;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {


    /**
     * Executes the command and returns the output message. As of now, we have no model, hence this abstract class is
     * not used. Abstract class of command can only be used when model is done
     *
     * @return feedback message of the operation result for display
     */
    public abstract CommandOutput execute();


}