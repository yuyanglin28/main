package model;

import common.LoggerController;
import model.Member;
import common.DukeException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

//@@author chenyuheng
public class Task {
    private String name;
    private boolean isDone;
    private ArrayList<String> memberList;
    private ArrayList<String> skillReqList;
    private Date time;

    public Task(String name) {
        this.name = name.trim();
        this.memberList = new ArrayList<>();
        this.skillReqList = new ArrayList<String>();
        addReqSkill("HOLA");
    }

    /**
     * add javadoc please
     */
    public void addMember(String toAdd) {
        if (!memberList.contains(toAdd)) {
            memberList.add(toAdd);
        }
    }

    /**
     * add javadoc please
     */
    public void deleteMember(String toDelete) {
        System.out.println(memberList);
        memberList.remove(toDelete);
    }

    public ArrayList<String> getMemberList() {
        return memberList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * change task to string to show on window
     *
     * @return string of task
     */
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.name + (time == null ? "" : (" (at: " + time + ")"));
    }

    /**
     * Return the status icon.
     *
     * @return the status icon ("V" for done and "x" for todo) of the task
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2715");
    }

    //@@author JustinChia1997
    /**
     * Adds a required skill to required skills array
     *
     * @return a boolean if addition was successful
     */
    public boolean addReqSkill(String skillName) {
        //TODO add regex to check for skillName
        if (!skillReqList.contains(skillName)) {
            skillReqList.add(skillName);
            LoggerController.logDebug(Task.class, "Added skill" + skillReqList.get(0));
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<String> getSkillReqList() {
        return skillReqList;
    }


}