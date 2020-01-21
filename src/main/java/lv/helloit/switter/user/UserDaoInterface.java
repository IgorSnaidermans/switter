package lv.helloit.switter.user;

import java.util.List;
import java.util.Optional;

public interface UserDaoInterface {
    void save(User user);

    User getUserById(String id);

    List<User> getAllUsers();

    Optional<User> getByEmail(String email);
}
