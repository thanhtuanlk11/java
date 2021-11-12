package myapplication.nguyenhuuthanhnam.myapplication;

public class Account {
    String email;
    String pass;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public Account(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }
}
