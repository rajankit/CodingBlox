package dao;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static int userCnt = 0;
    private static Map<String, User> userMap = new HashMap<>();

    private UserDao() {}

    public static int getUserCnt() {
        return userCnt;
    }

    public static Map<String, User> getUserMap() {
        return userMap;
    }
}
