package be.heh.secondprojet.BDD;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;

    public User() { }

    public User(String l, String p, String e) {
        this.login = l;
        this.password = p;
        this.email = e;
    }

    public int getId() {
        return id;
    }
    public void setId(int i) {
        this.id = i;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String l) {
        this.login = l;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String p) {
        this.password = p;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID : "
        + Integer.toString(getId()) + "\n"
        + "Login : " + getLogin() + "\n"
        + "Password : " + getPassword() + "\n"
        + "Email : " + getEmail());
        return sb.toString();
    }
}
