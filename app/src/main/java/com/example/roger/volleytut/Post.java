package com.example.roger.volleytut;

/**
 * Created by Roger on 6/12/14.
 */
public class Post {
    private String Account;
    private String Password;
    private String Name;
    private String Gender;
    private String Phone;
    private String Email;

    public Post(String Account, String Password, String Name, String Gender, String Phone, String Email){
        this.setAccount(Account);
        this.setPassword(Password);
        this.setName(Name);
        this.setGender(Gender);
        this.setPhone(Phone);
        this.setEmail(Email);
    }
    @Override
    public String toString(){
        return "UserName: "+ this.getName() +"\nEmail: "+ this.getEmail();
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount(String account) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
