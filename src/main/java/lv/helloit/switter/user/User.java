package lv.helloit.switter.user;

import java.util.Objects;

public class User {
    private String id;
    private String email;

    private User(Builder builder) {
        setId(builder.id);
        setEmail(builder.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class Builder {
        private String id;
        private String email;

        public Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

