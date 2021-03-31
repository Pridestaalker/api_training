package fr.esiea.ex4A;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



@Repository

public class UserRepository {
    final HashMap<String, User> users = new HashMap<String, User>();
    final HashMap<String, AgifyUser> userAs = new HashMap<String, AgifyUser>();
    private final Integer AGE_GAP = 4;

    public void addUser(User user, AgifyUser userA) {
        users.put(user.getId(), user);
        userAs.put(user.getId(), userA);
    }

    public ArrayList<User> matchUsers(User user) {
        ArrayList<User> filtredUsers = new ArrayList<User>();
        for (Map.Entry<String, AgifyUser> userA : userAs.entrySet()) {
            if (userA.getValue().age > userAs.get(user.getId()).age - 4 && userA.getValue().age < userAs.get(user.getId()).age + 4) {
                User userSelect = users.get(userA.getKey());
                if (userSelect.sex.equals(user.sexPref) && userSelect.sexPref.equals(user.sex)) {
                    filtredUsers.add(userSelect);
                }
            }
        }
        return filtredUsers;
    }
}

