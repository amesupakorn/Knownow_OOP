package Option_Login;

import java.io.FileReader;

public class Decoder implements PasswordCode{
    int position;
    String path;
    StringBuilder password= new StringBuilder();
    public Decoder(int position, String path) {
        this.position = position;
        this.path = path;
        eye();
    }
    public void eye(){
        try (FileReader fg = new FileReader(path);){
            char[] pass = new char[64];
            fg.read(pass);
            int lenPass;
            if( (pass[63]+"").equals("i")){
                lenPass = Integer.parseInt(""+pass[62]);
            }else{
                lenPass = Integer.parseInt(""+pass[62]+pass[63]);
            }
            
            for (int i=3; i<62;i=i+3){
                if(lenPass>0){
                    password.append(pass[i]);
                }else{
                    break;
                }
                lenPass--;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String toString(){
        return password.toString();
    }
    
}
