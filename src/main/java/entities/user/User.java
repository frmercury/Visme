package entities.user;

import static java.lang.System.getProperty;

public class User {

    protected String login;
    protected String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User() {
        this.login = getProperty("user.login");
        this.password = getProperty("user.password");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
