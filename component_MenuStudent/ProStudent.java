package component_MenuStudent;

import Option_Login.Students;
import java.io.File;
import javax.swing.ImageIcon;
import static main_MenuStudent.main_Student.nowLogin;

public class ProStudent extends javax.swing.JPanel implements Students{

    File f = new File(main_Login.Main.locatUserLogin.getAbsolutePath()+"/"+nowLogin.getUserName()+"/picProfile.png");

    public ProStudent() {
        initComponents();
        image();
        
        
    }
    public void user(String name){
        user.setText(name);
    }
    
    public void image(){
        if(f.exists()){
            ImageIcon icon = new ImageIcon(main_Login.Main.locatUserLogin.getAbsolutePath()+"/"+nowLogin.getUserName()+"/picProfile.png");
            imageAvatar1.setImage(icon);
        }
        else{
            ImageIcon icon = new ImageIcon(getClass().getResource("/icon/1414618-200.png"));
            imageAvatar1.setImage(icon);
        }
    }
    
    public void upimage(String file){
        ImageIcon icon = new ImageIcon(file);
        imageAvatar1.setImage(icon);
            
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        user = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        imageAvatar1 = new swing_MenuStudent.ImageAvatarStudent();

        setBackground(new java.awt.Color(255, 255, 255));

        user.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        user.setText("Username");

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel3.setText("Student");

        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/1414618-200.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(user)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(user)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_MenuStudent.ImageAvatarStudent imageAvatar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
