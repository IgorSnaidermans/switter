package lv.helloit.switter.user;

import com.sparkpost.exception.SparkPostException;
import lv.helloit.switter.swit.EmailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserService {

    private EmailService emailService;
    private UserDAO userDAO;

    public UserService(EmailService emailService, UserDAO userDAO) {
        this.emailService = emailService;
        this.userDAO = userDAO;
    }

    public void addUser(CreateUserDTO createUserDTO) {
        UUID uuid = UUID.randomUUID();
        User user = new User.Builder()
                .email(createUserDTO.getEmail())
                .id(uuid.toString())
                .build();

        userDAO.save(user);

        try {
            emailService.sendNewUserEmail(user.getEmail());
        } catch (SparkPostException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
