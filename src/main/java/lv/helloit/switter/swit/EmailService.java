package lv.helloit.switter.swit;

import com.sparkpost.Client;
import com.sparkpost.exception.SparkPostException;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendNewUserEmail(String userEmail) throws SparkPostException {
        String API_KEY = "339165f89dac945c6ad84fe63d2e8e89d505f7f8";
        Client client = new Client(API_KEY);

        client.sendMessage(
                "switter@mmm.id.lv",
                userEmail,
                "Greeting in switter",
                "You successfully registered",
                "<b>You successfully registered</b>");
    }
}
