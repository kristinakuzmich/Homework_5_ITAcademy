package by.it_academy.jd2.dto;
import java.time.LocalDateTime;
import java.util.Date;

public class User {
    private final String login;
    private final String password;
    private final String fullName;
    private final Date birthDate;
    private final LocalDateTime registrationDate;
    private final String role;

    public User(String login, String password, String fullName, Date birthDate, LocalDateTime registrationDate, String role) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", role='" + role + '\'' +
                '}';
    }

    public static class Builder {
        private String login;
        private String password;
        private String fullName;
        private Date birthDate;
        private LocalDateTime registrationDate;
        private String role;

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder registrationDate(LocalDateTime registrationDate) {
            this.registrationDate = registrationDate;
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(login, password, fullName, birthDate, registrationDate, role);
        }
    }
}