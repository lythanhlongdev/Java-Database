package controller;

public class Info {
    private  String info_id;
    private  String first_name;
    private  String last_name;
    private  int age;
    private  String email;
    private  String phone_Number;

    public  Info(){

    }
    public Info(String info_id, String first_name, String last_name, int age, String email, String phone_Number) {
        this.info_id = info_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
        this.email = email;
        this.phone_Number = phone_Number;
    }

    public String getInfo_id() {
        return info_id;
    }

    public void setInfo_id(String info_id) {
        this.info_id = info_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    @Override
    public String toString() {
        return "Info{" +
                "info_id='" + info_id + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone_Number='" + phone_Number + '\'' +
                '}';
    }
}
