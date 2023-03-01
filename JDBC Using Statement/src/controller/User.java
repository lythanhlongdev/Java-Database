package controller;

public class User {
    private String account;
    private String password;

    public User(){
        super();
    }
    public User(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{Account: "+this.account+", Password: "+this.password+" }";
    }
}
