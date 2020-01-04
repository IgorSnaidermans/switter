package lv.helloit.switter.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void addUser(CreateUserDTO createUserDTO) {
        UUID uuid = UUID.randomUUID();
        User user = new User.Builder()
                .email(createUserDTO.getEmail())
                .id(uuid.toString())
                .build();

        userDAO.save(user);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
