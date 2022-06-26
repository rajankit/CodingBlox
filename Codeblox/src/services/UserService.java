package services;

import dao.UserDao;
import enums.Level;
import enums.SortOrder;
import models.User;
import pointsStrategy.CalculatePointForForHighContest;
import pointsStrategy.CalculatePointForLowContest;
import pointsStrategy.CalculatePointForMediumContest;
import pointsStrategy.PointCalculate;

import java.util.*;

public class UserService {
    private static Map<String, User> userMap = UserDao.getUserMap();
    private static int userCnt = UserDao.getUserCnt();

    public void createUser(String name, int defaultScore) {
        String id = name + "_" + ++userCnt;
        User user = new User(name, id, defaultScore);

        userMap.put(id, user);
    }

    public void updateScore(String id, Level level, int total) {
        PointCalculate pointCalculate = null;

        if (level == Level.HIGH) {
            pointCalculate = new CalculatePointForForHighContest(total);
        } else if (level == Level.LOW) {
            pointCalculate = new CalculatePointForLowContest(total);
        } else if (level == Level.MEDIUM) {
            pointCalculate = new CalculatePointForMediumContest(total);
        }

        int finalPoint = pointCalculate.calculateScore();

        userMap.get(id).setScore(userMap.get(id).getScore() + finalPoint);
    }

    public void showLeaderBoard(SortOrder order) {
        ArrayList<String> leaderboard = new ArrayList<>();

        for(String id : userMap.keySet()) {
            String scoreName = userMap.get(id).getScore() + ":" + userMap.get(id).getName();
            leaderboard.add(scoreName);
        }

        if (order == SortOrder.ASC) {
            Collections.sort(leaderboard);
        } else {
            Collections.sort(leaderboard, Collections.reverseOrder());
        }

        for(String scoreName : leaderboard) {
            String sName[] = scoreName.split(":");
            System.out.println(sName[1] + " " + sName[0]);
        }
    }
}
