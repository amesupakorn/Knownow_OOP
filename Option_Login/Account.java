
package Option_Login;

import java.io.Serializable;
import java.util.LinkedList;

public abstract class Account implements Serializable{
    protected String userName;
    protected transient String password;
    protected String email;
    protected String phone;
    protected String birth;
    

    abstract public String getUserName();

    abstract public void setUserName(String userName);

    abstract public String getPassword();

    abstract public void setPassword(String password) ;

    abstract public String getEmail();

    abstract public void setEmail(String email);

    abstract public String getPhone();

    abstract public void setPhone(String phone);

    abstract public String getBirth();

    abstract public void setBirth(String birth) ;

    
    
}
