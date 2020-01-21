package lv.helloit.switter.user;

import com.sparkpost.exception.SparkPostException;
import lv.helloit.switter.security.PasswordService;
import lv.helloit.switter.swit.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class UserService {

    private PasswordService passwordService;
    private EmailService emailService;
    private UserDaoInterface userDAO;

    @Autowired
    public UserService(PasswordService passwordService, EmailService emailService, UserDaoInterface userDAO) {
        this.passwordService = passwordService;
        this.emailService = emailService;
        this.userDAO = userDAO;
    }


    public void addUser(CreateUserDTO createUserDTO) {
        UUID uuid = UUID.randomUUID();

        String hashedPassword = passwordService.hash(createUserDTO.getPassword());

        User user = new User.Builder()
                .email(createUserDTO.getEmail())
                .id(uuid.toString())
                .password(hashedPassword)
                .build();

        userDAO.save(user);

        /*try {
            emailService.sendNewUserEmail(user.getEmail());
        } catch (SparkPostException e) {
            e.printStackTrace();
        }*/
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }

    public User getUserById(String id){
        return userDAO.getUserById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userDAO.getByEmail(email);
    }
}
