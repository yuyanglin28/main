package model;

import utils.DukeException;

import java.util.ArrayList;

public class ModelController implements Model {
    private TasksManager tasksManager;
    private MemberManager memberManager;
    /**
     * Handles model changes.
     * */
    public ModelController() {
        //TODO change to loading from storage
        tasksManager = new TasksManager();
        memberManager = new MemberManager();
    }

    @Override
    public void load() {
        //TODO
    }

    @Override
    public void save() {
        //TODO
    }

    @Override
    public ArrayList<Task> getTaskList() {
        return tasksManager.getTaskList();
    }

    @Override
    public void addTask(String name) throws DukeException {
        tasksManager.addTask(name);
        save();
    }

    @Override
    public Task deleteTask(int index) throws DukeException {
        Task toDelete = tasksManager.getTaskById(index);
        ArrayList<Member> memberList = toDelete.getMemberList();
        for (int i = 0; i < memberList.size(); i++) {
            unlink(toDelete, memberList.get(i));
        }
        tasksManager.deleteTask(toDelete);
        save();
        return toDelete;
    }

    @Override
    public ArrayList<Member> getMemberList() {
        return memberManager.getMemberList();
    }

    @Override
    public void addMember(String name) throws DukeException {
        memberManager.addMember(name);
        save();
    }

    @Override
    public Member deleteMember(String name) throws DukeException {
        Member toDelete = memberManager.getMemberByName(name);
        ArrayList<Task> taskArrayList = toDelete.getTaskList();
        for (int i = 0; i < taskArrayList.size(); i++) {
            unlink(taskArrayList.get(i), toDelete);
        }
        memberManager.deleteMember(toDelete);
        save();
        return toDelete;
    }

    @Override
    public void link(int tasksIndexes, String memberNames) {
        Task task = tasksManager.getTaskById(tasksIndexes);
        Member member = memberManager.getMemberByName(memberNames);
        task.addMember(member);
        member.addTask(task);
        save();
    }

    @Override
    public void unlink(int tasksIndexes, String memberNames) {
        Task task = tasksManager.getTaskById(tasksIndexes);
        Member member = memberManager.getMemberByName(memberNames);
        unlink(task, member);
        save();
    }

    private void unlink(Task task, Member member) {
        task.deleteMember(member);
        member.deleteTask(task);
    }
}