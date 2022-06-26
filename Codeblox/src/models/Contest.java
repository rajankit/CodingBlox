package models;

import enums.Level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Contest {
    private String id;
    private Level level;
    private String creator;
    private String name;

    private int points;
    private ArrayList<String> userList;
    private Map<String, ArrayList<String>> userQuestionMap;

    public Contest(String id, Level level, String creator, String name) {
        this.id = id;
        this.level = level;
        this.creator = creator;
        this.name = name;
        this.userList = new ArrayList<>();
        this.userQuestionMap = new HashMap<>();
    }

    public void addUser(String id) {
        this.userList.add(id);
    }

    public ArrayList<String> getUserList() {
        return this.userList;
    }

    public void setUserQuestions(String id, ArrayList<String> questions) {
        this.userQuestionMap.put(id, questions);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
