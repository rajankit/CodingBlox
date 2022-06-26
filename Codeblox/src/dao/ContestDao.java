package dao;

import enums.Level;
import models.Contest;
import models.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContestDao {

    private static int currentContestPoint = 100;
    private static int contestCnt = 0;
    private static Map<String, Contest> contestMap = new HashMap<>();
    private static Map<Level, ArrayList<String>> contestLevelMap = new HashMap<>();

    private ContestDao() {}

    public static int getContestCnt() {
        return contestCnt;
    }

    public static Map<String, Contest> getContestMap() {
        return contestMap;
    }

    public static Map<Level, ArrayList<String>> getContestLevelMap() {
        return contestLevelMap;
    }

    public static int getCurrentContestPoint() {
        return currentContestPoint;
    }
}
