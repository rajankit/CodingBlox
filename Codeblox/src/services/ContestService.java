package services;

import dao.ContestDao;
import enums.Level;
import models.Contest;
import models.User;

import java.util.ArrayList;
import java.util.Map;

public class ContestService {
    private static int contestCnt = ContestDao.getContestCnt();
    private static int currentContestPoint = ContestDao.getCurrentContestPoint();
    private static Map<String, Contest> contestMap = ContestDao.getContestMap();
    private static Map<Level, ArrayList<String>> contestLevelMap = ContestDao.getContestLevelMap();
    private QuestionService questionService = new QuestionService();
    private UserService userService = new UserService();

    private String generateContestId() {
        return "contest_" + ++contestCnt;
    }

    private void printContest(Contest contest) {
        System.out.println(contest.getName() + " " + contest.getLevel() + " " + contest.getCreator());
    }
    public void createContest(String contestName, Level level, String creator) {
        String id = generateContestId();
        Contest contest = new Contest(id, level, creator, contestName);

        contestMap.put(id, contest);

        if (!contestLevelMap.containsKey(level)) {
            contestLevelMap.put(level, new ArrayList<>());
        }

        contestLevelMap.get(level).add(id);

        attendContest(id, creator);
    }

    public void listContests(Level level) {
        if (!contestLevelMap.containsKey(level) || contestLevelMap.get(level).size() == 0) {
            System.out.println("CodingBlox is yet to have " + level + " Contest");
            return;
        }

        for(String id : contestLevelMap.get(level)) {
            printContest(contestMap.get(id));
        }
    }

    public void listContests() {
        if (contestMap.keySet().size() == 0) {
            System.out.println("CodingBlox is yet to have Contest");
            return;
        }

        for(String id : contestMap.keySet()) {
            printContest(contestMap.get(id));
        }
    }

    public void attendContest(String contestId, String userId) {
        Contest contest = contestMap.get(contestId);
        contest.addUser(userId);
    }

    public void runContest(String contestId, String creator) {
        Contest contest = contestMap.get(contestId);

        if (contest.getCreator() != creator) {
            System.out.println("Only contest creator can run the contest");
            return;
        }

        for(String userId : contest.getUserList()) {
            contest.setUserQuestions(userId, questionService.getRandomQuestions(contest.getLevel()));
            userService.updateScore(userId, contest.getLevel(), currentContestPoint);
        }
    }
}
