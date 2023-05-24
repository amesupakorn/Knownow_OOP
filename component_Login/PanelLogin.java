package component_Login;

import Option_Login.Account_Student;
import swing_Login.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import Option_Login.Decoder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing_Login.MyPasswordField;
import swing_Login.MyTextField;
import main_Login.Main;

public class PanelLogin extends javax.swing.JLayeredPane {
    
        private MigLayout layout;
        public static String nowInUse;
        
    public PanelLogin(ActionListener eventRegisterStudent, ActionListener eventVertify) {
      
        initComponents();
        initTeacher(eventVertify);
        initStudent(eventRegisterStudent);

        teacher.setVisible(true);
        student.setVisible(true);
        
    }
    private void initStudent(ActionListener eventRegisterStudent){

        student.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]25[]10[]push"));
        JLabel label = new JLabel("Student Accounts");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(29, 20, 180));
        student.add(label);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        student.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        student.add(txtPass, "w 60%");
                       
        Button cmd = new Button();
        cmd.setBackground(new Color(29, 20, 180));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
        
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if (txtUser.getText().equals("")){
                    showMessages(MessageLogin.MessageType.ERROR, "Please enter your Username.");
                }
                else if (String.valueOf(txtPass.getPassword()).equals("")){
                    showMessages(MessageLogin.MessageType.ERROR, "Please enter your Password.");
                }else{
                    //Action if User and Password not empty.
                    File logIn = new File(Main.locatUserLogin.getAbsolutePath()+"/"+txtUser.getText());
                    if (logIn.exists()){
                        String confirmToEnter = new Decoder(3, logIn+"/EncodedPassword.dat").toString();

                        boolean condi = confirmToEnter.equals(String.valueOf(txtPass.getPassword()));
                        if (condi){
                            showMessages(MessageLogin.MessageType.SUCCESS, "Successfull");
                            try (FileInputStream fr = new FileInputStream(logIn.getAbsolutePath()+"/Body.dat");
                                    ObjectInputStream oout = new ObjectInputStream(fr);){
                                    main_MenuStudent.main_Student.nowLogin = (Option_Login.Account_Student) oout.readObject();
                                
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            new main_MenuStudent.main_Student().setVisible(true);
                            main_Login.Main.loginObject.dispose();
                        }else{
                            showMessages(MessageLogin.MessageType.ERROR, "Password incorrect.");
                            
                        }
                    }else{
                        showMessages(MessageLogin.MessageType.ERROR, "Account Username : "+txtUser.getText()+" (Not already to Used)");
                    }
                }
              }
            });
        student.add(cmd, "w 35%, h 35");
        
        JButton cmd2Forget = new JButton("SIGN UP");
        cmd2Forget.setForeground(new Color(100, 100, 100));
        cmd2Forget.setFont(new Font("sansserif", 1, 10));
        cmd2Forget.setContentAreaFilled(false);
        cmd2Forget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd2Forget.addActionListener(eventRegisterStudent);
        student.add(cmd2Forget);
        
        
    }
    private void initTeacher(ActionListener eventVertify){
        teacher.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]25[]10[]push"));
        JLabel label = new JLabel("Teacher Accounts");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(29, 20, 180));
        teacher.add(label);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        teacher.add(txtUser, "w 60%");
        MyPasswordField txtPass = new MyPasswordField();
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        teacher.add(txtPass, "w 60%");
                
        Button cmd = new Button();
        cmd.setBackground(new Color(29, 20, 180));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN IN");
       
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if (txtUser.getText().equals("")){
                    showMessaget(MessageLogin.MessageType.ERROR, "Please enter your Username.");
                }
                else if (String.valueOf(txtPass.getPassword()).equals("")){
                    showMessaget(MessageLogin.MessageType.ERROR, "Please enter your Password.");
                }else{
                    //Action if User and Password not empty.
                    File logIn = new File(Main.locatData.getAbsolutePath()+"/Teacher/"+txtUser.getText());
                    nowInUse = logIn.getAbsolutePath();
                    if (logIn.exists()){
                        String confirmToEnter = new Decoder(3, logIn+"/EncodedPassword.dat").toString();

                        boolean condi = confirmToEnter.equals(String.valueOf(txtPass.getPassword()));
                        if (condi){
                            showMessaget(MessageLogin.MessageType.SUCCESS, "Successfull");
                            try (FileInputStream fr = new FileInputStream(logIn.getAbsolutePath()+"/Body.dat");
                                    ObjectInputStream oout = new ObjectInputStream(fr);){
                                    main_MenuTeacher.Main_Teacher.nowLoginn = (Option_Login.Account_Teacher) oout.readObject();
                                
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            new main_MenuTeacher.Main_Teacher().setVisible(true);
                            main_Login.Main.loginObject.dispose();
                        }else{
                            showMessaget(MessageLogin.MessageType.ERROR, "Password incorrect.");
                            
                        }
                    }else{
                        showMessaget(MessageLogin.MessageType.ERROR, "Account Username : "+txtUser.getText()+" (Not already to Used)");
                    }
                }
              }
            });
        teacher.add(cmd, "w 35%, h 35");
        JButton cmd2Forget = new JButton("SIGN UP");
        cmd2Forget.setForeground(new Color(100, 100, 100));
        cmd2Forget.setFont(new Font("sansserif", 1, 10));
        cmd2Forget.setContentAreaFilled(false);
        cmd2Forget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd2Forget.addActionListener(eventVertify);
        teacher.add(cmd2Forget);
        


    }
    private void showMessages(MessageLogin.MessageType messageType, String message) {
        MessageLogin ms = new MessageLogin();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    student.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    student.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
//                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                student.repaint();
                student.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    student.remove(ms);
                    student.repaint();
                    student.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
    private void showMessaget(MessageLogin.MessageType messageType, String message) {
        MessageLogin ms = new MessageLogin();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    teacher.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    teacher.repaint();
                }
            }

            @Override
            public void timingEvent(float fraction) {
                float f;
                if (ms.isShow()) {
                    f = 40 * (1f - fraction);
                } else {
                    f = 40 * fraction;
                }
//                layout.setComponentConstraints(ms, "pos 0.5al " + (int) (f - 30));
                teacher.repaint();
                teacher.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    teacher.remove(ms);
                    teacher.repaint();
                    teacher.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    animator.start();
                } catch (InterruptedException e) {
                    System.err.println(e);
                }
            }
        }).start();
    }
//        
    public void showTeacher(boolean show){
        if (show){
            student.setVisible(true);
            teacher.setVisible(false);
        }
        else{
            student.setVisible(false);
            teacher.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student = new javax.swing.JPanel();
        teacher = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout());

        student.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout studentLayout = new javax.swing.GroupLayout(student);
        student.setLayout(studentLayout);
        studentLayout.setHorizontalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        studentLayout.setVerticalGroup(
            studentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(student, "card3");

        teacher.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout teacherLayout = new javax.swing.GroupLayout(teacher);
        teacher.setLayout(teacherLayout);
        teacherLayout.setHorizontalGroup(
            teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        teacherLayout.setVerticalGroup(
            teacherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(teacher, "card2");
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel student;
    private javax.swing.JPanel teacher;
    // End of variables declaration//GEN-END:variables

}
