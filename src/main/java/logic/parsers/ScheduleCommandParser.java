package logic.parsers;

import logic.commands.Command;
import logic.commands.ViewScheCommand;
import utils.DukeException;

public class ScheduleCommandParser {
    public static Command parse(String userInput) throws DukeException {
        return new ViewScheCommand(userInput); //TODO
    }
}
