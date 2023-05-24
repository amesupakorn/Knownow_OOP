
package Option_Login;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.util.Random;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class Encoder implements PasswordCode{
    
    private String User, Password, Phone, Local;
    private String word = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private Random random = new Random();
    public Encoder(String User, String Password, String Phone, String Local){
        this.User = User;
        this.Phone = Phone;
        this.Password = Password;
        this.Local = Local;  
        calculat();
        
    }
    
    public void calculat() {
        String[] PassCode = new String[20];
                        //Encoder Password
        int passlen = Password.length();
        String user = setEn(User, User.length(), PassCode);
        String phone = setEn(Phone, Phone.length(), PassCode);
        String password = setEn(Password, Password.length(), PassCode);
        try (FileWriter oOut = new FileWriter(Local+"/EncodedPassword.dat");
                BufferedWriter encoder = new BufferedWriter(oOut);){
            int pas = 0, us = 0, ph = 0;
            for (int i =0; i< 62;i++){
                if (i < 2){
                    encoder.write("6");
                }else if (i%3 == 0){
                    encoder.write(""+password.charAt(pas));
                    pas++;
                }else if (i%4 == 0){
                    encoder.write(""+user.charAt(us));
                    us++;
                }else{
                    try {
                        encoder.write(""+phone.charAt(ph));
                        ph++;
                    } catch (Exception e) {
                        int index = random.nextInt(word.length());
                        encoder.write(word.charAt(index)+"");
                    }
                }
            }
            if(passlen < 10){
                encoder.write(passlen+"i");
            }else{
                encoder.write(passlen+"");
            }
            
        } catch (Exception e) {
        } 
    }
    public String setEn(String source, int power, String[] valueSet){
        for(int i=0;i < 20;i++){
            if(i<power){
                
                valueSet[i] = String.valueOf(source.charAt(i));
            }else{
                int index = random.nextInt(word.length());
                valueSet[i] = word.charAt(index)+"";
            }
        }
        source = String.join("", valueSet);
        return source;
    }
}
