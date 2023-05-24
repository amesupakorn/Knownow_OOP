package Option_Login;

import java.io.Serializable;
import java.util.LinkedList;

public class Account_Student extends Account implements Serializable, Students{
    private String namePeople;
    private String pathCourse;
    
    
    public Account_Student(){
        this("", "", "", "");
        
    }
    public Account_Student(String userName, String password, String email, String phone){
        this(userName, password, email, phone, " ", " ");
    }
    
    public Account_Student(String userName, String password, String email, String phone, String birth, String name){
        this.namePeople = name;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
        
    }
    
    public void setNamePeople(String name){
        this.namePeople = name;
    }
    public String getNamePeople(){
        return namePeople;
    }
    
    //Get Data
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPathCourse() {
        return pathCourse;
    }

    public void setPathCourse(String pathCourse) {
        this.pathCourse = pathCourse;
    }

    
    
}
