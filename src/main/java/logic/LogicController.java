package logic;

import logic.command.CommandOutput;
import logic.parser.NewParser;
import tasks.Task;
import utils.Storage;

import java.util.ArrayList;

public class LogicController {

    protected ArrayList<Task> tasks;
    protected Storage storage;
    private NewParser parser;


    public LogicController(ArrayList<Task> tasks, Storage storage) {
        this.tasks = tasks;
        this.storage = storage;
    }

    public CommandOutput execute(String fullCommand){

    }

}
