package dao;

import enums.Level;
import models.Question;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QuestionDao {
    private static int questionCnt = 0;
    private static Map<String, Question> questionMap = new HashMap<>();
    private static Map<Level, ArrayList<String>> questionLevelMap = new HashMap<>();

    private QuestionDao() {}

    public static int getQuestionCnt() {
        return questionCnt;
    }

    public static Map<Level, ArrayList<String>> getQuestionLevelMap() {
        return questionLevelMap;
    }

    public static Map<String, Question> getQuestionMap() {
        return questionMap;
    }
}
