package model;

import model.task.ToDo;

public class ModelController implements Model {
    private ProjectManager projectManager;

    public ModelController() {
        //Create new project manager object, TODO change to loading from storage
        projectManager = new ProjectManager();

    }

    @Override
    public void addToDo(ToDo todo) {
        projectManager.addTodo(todo);
    }
}
