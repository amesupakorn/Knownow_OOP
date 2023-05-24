package Option_Login;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Account_Teacher extends Account implements Serializable, Teacher{
    
    private String pathCourse;
    
    private ArrayList<String> ownCourse = new ArrayList<>();

    public Account_Teacher(){
        this("", "", "", "", "");
        
    }
    public Account_Teacher(String userName, String password, String email, String phone, String pathCourse){
        this(userName, password, email, phone, pathCourse, new ArrayList<>());
    }
    public Account_Teacher(String userName, String password, String email, String phone, String pathCourse, ArrayList<String> ownCourse){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.pathCourse = pathCourse;
        this.ownCourse = ownCourse;
        
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

    public ArrayList<String> getOwnCourse() {
        return ownCourse;
    }

    public void setOwnCourse(ArrayList<String> ownCourse) {
        this.ownCourse = ownCourse;
    }
    
    public void addFile(String name){
        this.ownCourse.add(name);
    }
    
    
}
