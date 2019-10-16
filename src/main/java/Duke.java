import logic.LogicController;
import members.Member;
import gui.Window;
//import commands.Command;
import model.Model;
import model.ModelController;
import tasks.Task;
import utils.DukeException;
//import utils.Parser;
import utils.Storage;
import utils.Reminder;
//import core.Ui;
import gui.UiController;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the main class to be executed for DUKE PRO application
 *
 * @author T14-4 team
 */
public class Duke {

    /**
     * deals with loading tasks from the file and saving tasks in the file
     */
    private Storage storage;

    /**
     * an array list contains all the tasks
     */
    private ArrayList<Task> tasks;

    private ArrayList<Member> members;

    /**
     * main components of application
     */
    protected LogicController logicController;
    protected UiController uiController;
    protected Model modelController;


    /**
     * A constructor which applies the file path to load previous data
     *
     * @param taskFilePath   the file path of task list
     * @param memberFilePath the file path of member list
     */
    public Duke(String taskFilePath, String memberFilePath) {
//        storage = new Storage(taskFilePath, memberFilePath);
//        tasks = storage.loadTaskList();
//        members = storage.loadMemberList();
        modelController = new ModelController();
        logicController = new LogicController(modelController);
        uiController = new UiController(logicController);
    }

    /**
     * main running structure of Duke.
     */
    public void run() throws DukeException {
        //Window window = new Window();
        uiController.welcome();
        //Reminder.checkReminders(tasks);
        boolean isExit = false;
        Scanner in = new Scanner(System.in);
        while (!isExit) {
//            try {
            uiController.readCommand(in);
//                String fullCommand = Ui.readLine(in);
//                Command c = Parser.commandLine(fullCommand);
//                c.execute(tasks, members, storage);
            isExit = uiController.isExit();
//            }
//            } catch (DukeException e) {
//                uiController.print(e.getMessage());
//            }
        }
    }

    /**
     * Main method of the entire project.
     *
     * @param args command line arguments, not used here
     */
    public static void main(String[] args) throws DukeException {
        new Duke("data/tasks.txt", "data/members.txt").run();
    }
}
