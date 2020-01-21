package lv.helloit.switter.user;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        return new User.Builder()
                .email(rs.getString("email"))
                .id(rs.getString("id"))
                .password(rs.getString("passwordhash"))
                .build();
    }
}
