package lv.helloit.switter.security;

import lv.helloit.switter.user.User;
import lv.helloit.switter.user.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;
import java.util.Optional;


@Component
public class SwitterAuthenticationProvider implements AuthenticationProvider {
    private UserService userService;
    private PasswordService passwordService;

    public SwitterAuthenticationProvider(UserService userService, PasswordService passwordService) {
        this.userService = userService;
        this.passwordService = passwordService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (authentication.getCredentials() == null) {
            throw new BadCredentialsException("No password was provided");
        }

        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<User> possibleUser = userService.getUserByEmail(email);

        if (possibleUser.isPresent()) {
            User user = possibleUser.get();

            return validatePassword(email, password, user);
        } else {
            throw new BadCredentialsException("No such user");
        }
    }

    private Authentication validatePassword(String email, String password, User user) {
        if (passwordService.checkPassword(password, user.getPasswordHash())) {
            return new UsernamePasswordAuthenticationToken(
                    email,
                    password,
                    List.of(new SimpleGrantedAuthority("USER")));
        } else {
            throw new BadCredentialsException("Wrong password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
