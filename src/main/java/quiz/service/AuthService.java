package quiz.service;


import com.google.gson.reflect.TypeToken;
import quiz.model.User;
import quiz.util.FileUtil;

import java.lang.reflect.Type;
import java.util.List;

public class AuthService {
    private static final String USERS_FILE = "users.json";

    public AuthService() {
        FileUtil.createFileIfNotExists(USERS_FILE);
        initializeDefaultUsers();
    }

    private void initializeDefaultUsers() {
        Type userListType = new TypeToken<List<User>>(){}.getType();
        List<User> users = FileUtil.readJsonFile(USERS_FILE, userListType);

        if (users.isEmpty()) {
            users.add(new User("admin", "1234", "admin"));
            users.add(new User("salman", "1234", "student"));
            FileUtil.writeJsonFile(USERS_FILE, users);
        }
    }

    public User authenticate(String username, String password) {
        Type userListType = new TypeToken<List<User>>(){}.getType();
        List<User> users = FileUtil.readJsonFile(USERS_FILE, userListType);

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }
}