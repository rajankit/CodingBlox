package services;

import dao.QuestionDao;
import enums.Level;
import models.Question;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class QuestionService {
    private static int questionCnt = QuestionDao.getQuestionCnt();
    private  static Map<String, Question> questionMap = QuestionDao.getQuestionMap();
    private  static Map<Level, ArrayList<String>> questionLevelMap = QuestionDao.getQuestionLevelMap();

    private String generateQuestionId() {
        return "Question_" + ++questionCnt;
    }

    private void printQuestion(Question question) {
        System.out.println(question.getId() + " " + question.getLevel());
    }
    public void createQuestion(Level level) {
        String questionId = generateQuestionId();
        Question question = new Question(questionId, level);

        questionMap.put(questionId, question);

        if (!questionLevelMap.containsKey(level)) {
            questionLevelMap.put(level, new ArrayList<>());
        }

        questionLevelMap.get(level).add(questionId);
    }

    public ArrayList<String> getRandomQuestions(Level level) {
        ArrayList<String> questions = questionLevelMap.get(level);

        ArrayList<String> questionsToBeAssigned = new ArrayList<>();

        Random random = new Random();
        int randIds[] = random.ints(Math.min(3, questions.size()), 0, questions.size()).distinct().toArray();

        for(int id : randIds) {
//            System.out.println(id);
            questionsToBeAssigned.add(questions.get(id));
        }

        return questionsToBeAssigned;
    }

    public void listQuestions(Level level) {
        if (!questionLevelMap.containsKey(level) || questionLevelMap.get(level).size() == 0) {
            System.out.println("CodingBlox is yet to have " + level + " Question");
            return;
        }

        for(String id : questionLevelMap.get(level)) {
            printQuestion(questionMap.get(id));
        }
    }

    public void listQuestions() {
        if (questionMap.keySet().size() == 0) {
            System.out.println("CodingBlox is yet to have Questions");
            return;
        }

        for(String id : questionMap.keySet()) {
            printQuestion(questionMap.get(id));
        }
    }
}
