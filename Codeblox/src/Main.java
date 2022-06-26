import enums.Level;
import enums.SortOrder;
import services.ContestService;
import services.QuestionService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        QuestionService questionService = new QuestionService();
        ContestService contestService = new ContestService();

        // create user
        userService.createUser("Ross", 1500);
        userService.createUser("Alice", 1500);
        userService.createUser("Bob", 1500);

        // create question
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.HIGH);
        questionService.createQuestion(Level.LOW);
        questionService.createQuestion(Level.LOW);
        questionService.createQuestion(Level.LOW);
        questionService.createQuestion(Level.LOW);
        questionService.createQuestion(Level.MEDIUM);
        questionService.createQuestion(Level.MEDIUM);
        questionService.createQuestion(Level.MEDIUM);
        questionService.createQuestion(Level.MEDIUM);

        // List question
        // questionService.listQuestions(Level.HIGH); // using level
        // questionService.listQuestions(); // all question
        // questionService.listQuestions(Level.LOW);

        // create contest
        contestService.createContest("Diwali Contest", Level.HIGH, "Ross_1");
        contestService.createContest("Holi Contest", Level.LOW, "Ross_1");
        contestService.createContest("New Year Contest", Level.MEDIUM, "Alice_2");

        // List Contest
        // contestService.listContests(Level.HIGH);
        // contestService.listContests();
        // contestService.listContests(Level.LOW);

        // attend contest
        contestService.attendContest("contest_1", "Alice_2");
        contestService.attendContest("contest_1", "Bob_3");

        contestService.attendContest("contest_2", "Alice_2");
        contestService.attendContest("contest_3", "Bob_3");

        // run a contest
        contestService.runContest("contest_1", "Ross_1");
        contestService.runContest("contest_2", "Ross_1");
        contestService.runContest("contest_3", "Alice_2");
        // leader_board
        // userService.showLeaderBoard(SortOrder.ASC);
        userService.showLeaderBoard(SortOrder.DES);
    }
}