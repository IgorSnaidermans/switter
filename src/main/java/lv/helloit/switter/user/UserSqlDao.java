package lv.helloit.switter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserSqlDao implements UserDaoInterface {
    static final String DB_URL = "jdbc:postgresql://ec2-54-247-181-232.eu-west-1.compute.amazonaws.com:5432/ddlvu5pf94g6u3";
    static final String DB_USER = "ubtflmsvlsvcla";
    static final String DB_PASSWORD = "b874bc49a245517ecaf7de62b7fd42bde8e08a445eef647e20804376ca045bd9";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserSqlDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO \"USER\"(id, email, passwordhash) " +
                "VALUES ('" + user.getId() + "', '" + user.getEmail() + "', '" + user.getPasswordHash() + "')";
        jdbcTemplate.update(query);

    }

    @Override
    public User getUserById(String id) {
        String query = "SELECT * FROM \"USER\" WHERE id = '" + id + "'";
        return jdbcTemplate.queryForObject(query, new UserRowMapper());
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public Optional<User> getByEmail(String searchEmail) {
        String query = "SELECT * FROM \"USER\" WHERE email = '" + searchEmail + "'";
        User user = jdbcTemplate.queryForObject(query, new UserRowMapper());
        return Optional.ofNullable(user);
    }



    /*@Override
    public List<User> getAllUsers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM \"USER\"");


            List<User> userList = new ArrayList<>();

            while (rs.next()) {
                User user = new User.Builder()
                        .email(rs.getString("email"))
                        .id(rs.getString("id").toString())
                        .password(rs.getString("passwordhash"))
                        .build();
                userList.add(user);
            }

            return userList;

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, statement, rs);
        }
        return null;
    }
    */
}
