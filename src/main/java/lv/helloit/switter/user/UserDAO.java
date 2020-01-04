package lv.helloit.switter.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAO {
    private List<User> users = new ArrayList<>();

    public void save(User user) {
        users.add(user);
    }

    public User getUserById(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .get();
    }

    public List<User> getAllUsers() {
        return users;
    }
}
