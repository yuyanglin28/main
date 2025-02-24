package logic.command.schedule;

import common.DukeException;
import logic.command.Command;
import logic.command.CommandOutput;
import model.Model;

public class ScheduleTeamTodoCommand extends Command {

    private static final String SUCCESS_MSSAGE = "Schedule todo tasks of the whole team: ";
    private static final String EMPTY_MSSAGE = "No todo task for the whole team.";

    //@@author yuyanglin28

    /**
     * This method is to schedule todo tasks
     * @param model Model interface
     * @return sorted todo tasks
     */
    @Override
    public CommandOutput execute(Model model) {
        String tasks = model.tasksTodoInorderTime();
        if (tasks.equals("")) {
            return new CommandOutput(EMPTY_MSSAGE);
        } else {
            return new CommandOutput(SUCCESS_MSSAGE + tasks);
        }


    }
}
