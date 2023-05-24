
package component_ProfileStudent;

import Option_Login.Students;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main_MenuStudent.main_Student;
import static main_MenuStudent.main_Student.nowLogin;

public class ViewStudent extends javax.swing.JPanel implements Students{
    
    File defImage = new File("default.png");
    File f = new File(main_Login.Main.locatUserLogin.getAbsoluteFile()+"/"+nowLogin.getUserName()+"/picProfile.png");
    
    public ViewStudent() {
        
        initComponents();
        if(f.exists()){
            ImageIcon icon = new ImageIcon(main_Login.Main.locatUserLogin.getAbsoluteFile()+"/"+nowLogin.getUserName()+"/picProfile.png");
            imageAvatar1.setImage(icon);
        }
        else{
            ImageIcon icon = new ImageIcon(getClass().getResource("/icon/1414618-200.png"));
            imageAvatar1.setImage(icon);
        }
    }
 
    public void update(){
        name.setText(nowLogin.getNamePeople());
        mail.setText(nowLogin.getEmail());
        birth.setText(nowLogin.getBirth());
        phon.setText(nowLogin.getPhone());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonEdit1 = new component_ProfileStudent.ButtonEdit();
        bg = new javax.swing.JLayeredPane();
        ProfileView = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        phon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        birth = new javax.swing.JTextField();
        edit = new swing_TeacherCreate.ButtonGradient();
        imageAvatar1 = new swing_MenuStudent.ImageAvatarStudent();
        buttonEdit2 = new component_ProfileStudent.ButtonEdit();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(247, 247, 247));
        bg.setOpaque(true);

        ProfileView.setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel1.setText("Name :");

        name.setEditable(false);
        name.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel2.setText("Phone Number : ");

        phon.setEditable(false);
        phon.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        phon.setBorder(null);

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel3.setText("E-mail :");

        mail.setEditable(false);
        mail.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        mail.setBorder(null);

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel4.setText("Birth :");

        birth.setEditable(false);
        birth.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        birth.setBorder(null);
        birth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthActionPerformed(evt);
            }
        });

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/edit.png"))); // NOI18N
        edit.setText(" Edit Profile");
        edit.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/1414618-200.png"))); // NOI18N

        buttonEdit2.setBackground(new java.awt.Color(51, 51, 51));
        buttonEdit2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/edit.png"))); // NOI18N
        buttonEdit2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonEdit2MousePressed(evt);
            }
        });
        imageAvatar1.add(buttonEdit2);
        buttonEdit2.setBounds(130, 100, 40, 40);

        javax.swing.GroupLayout ProfileViewLayout = new javax.swing.GroupLayout(ProfileView);
        ProfileView.setLayout(ProfileViewLayout);
        ProfileViewLayout.setHorizontalGroup(
            ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileViewLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ProfileViewLayout.createSequentialGroup()
                        .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phon, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProfileViewLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ProfileViewLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ProfileViewLayout.createSequentialGroup()
                        .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(241, 241, 241)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        ProfileViewLayout.setVerticalGroup(
            ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProfileViewLayout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(imageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ProfileViewLayout.createSequentialGroup()
                        .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ProfileViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.setLayer(ProfileView, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ProfileView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(ProfileView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        
    }//GEN-LAST:event_nameActionPerformed

    private void birthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        new EditProfile().setVisible(true);
        
    }//GEN-LAST:event_editActionPerformed

    private void buttonEdit2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEdit2MousePressed
 
        JFileChooser ch = new JFileChooser();
        ch.showOpenDialog(new JFrame());
        if(ch.getSelectedFile().getAbsolutePath().endsWith(".png") || ch.getSelectedFile().getAbsolutePath().endsWith(".jpg")){
            defImage = ch.getSelectedFile();
            ImageIcon icon = new ImageIcon(defImage.getAbsolutePath());
            imageAvatar1.setImage(icon);
            String folder = main_Login.Main.locatUserLogin.getAbsolutePath()+"/"+main_Student.nowLogin.getUserName();
            File destination = new File(folder + "/picProfile.png");
            try{
                destination.delete();
                Files.copy(defImage.toPath(), destination.toPath());
                main_MenuStudent.main_Student.pro1.upimage(defImage.getAbsolutePath());
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "Please Upload File Again ;.png, .jpg", null, JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_buttonEdit2MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ProfileView;
    private javax.swing.JLayeredPane bg;
    private javax.swing.JTextField birth;
    private component_ProfileStudent.ButtonEdit buttonEdit1;
    private component_ProfileStudent.ButtonEdit buttonEdit2;
    private swing_TeacherCreate.ButtonGradient edit;
    private swing_MenuStudent.ImageAvatarStudent imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField name;
    private javax.swing.JTextField phon;
    // End of variables declaration//GEN-END:variables
}
