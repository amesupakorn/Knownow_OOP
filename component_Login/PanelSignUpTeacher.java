package component_Login;


import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import Option_Login.Encoder;
import Option_Login.Account_Student;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing_Login.Button;
import swing_Login.MyPasswordField;
import swing_Login.MyTextField;

public class PanelSignUpTeacher extends javax.swing.JPanel {
    
    private MigLayout layout;
    private main_Login.Main importmain;//Use static vairable is loacatUserLogin of class main
    
    
    public PanelSignUpTeacher() {
        initComponents();
        initRegister();
        setOpaque(false);
        setFocusCycleRoot(true);
        super.setVisible(false);
        addMouseListener(new MouseAdapter() {
        });
        
        register.setVisible(true);
        
    }
    
    private void initRegister(){
        layout = new MigLayout("fill, insets 0");
        
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]20[]20[]10[]10[]10[]10[]10[]10[]15[]push"));
        JLabel label1 = new JLabel("");
        JLabel label2 = new JLabel("");
        JLabel label3 = new JLabel("");
        JLabel label4 = new JLabel("");
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 35));
        label.setForeground(new Color(29, 20, 180));
        
        register.add(label1);
        register.add(label2);
        register.add(label3);
        register.add(label4);
        register.add(label);
        register.add(label2);
        register.add(label4);
        
        MyTextField txtUser = new MyTextField();
        txtUser.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        txtUser.setHint("Username");
        register.add(txtUser, "w 95%");
        MyTextField txtEmail = new MyTextField();
        txtEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        txtEmail.setHint("Email");
        register.add(txtEmail, "w 95%");
        
        MyTextField txtPhone = new MyTextField();
        txtPhone.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/phone.png")));

        txtPhone.setHint("Phone number");
        register.add(txtPhone, "w 95%");
        MyPasswordField txtPass = new MyPasswordField();
        
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 95%");
        MyPasswordField txtPass2 = new MyPasswordField();
        txtPass2.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass2.setHint("Confirm Password");
        register.add(txtPass2, "w 95%");
                                 
        register.add(label2);
        Button cmd = new Button();
        cmd.setBackground(new Color(29, 20, 180));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                boolean conPhoneInt = false;
                try {
                    Integer.parseInt(txtPhone.getText());
                } catch (Exception e) {
                    conPhoneInt = true;
                }
                if(txtUser.getText().equals("")){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please enter your username.");
                }
                else if(txtEmail.getText().equals("")){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please enter your Email.");
                }
                else if(txtPhone.getText().equals("")){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please enter your Phone number.");
                }
                else if(conPhoneInt){
                    showMessage(MessageSignUp.MessageType.ERROR, "Phone number is not Integer.");
                }
                else if(txtPhone.getText().length()<10){
                    showMessage(MessageSignUp.MessageType.ERROR, "Phone number is not complete.");
                }
                else if(String.valueOf(txtPass.getPassword()).equals("")){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please enter your Password.");
                }
                else if(String.valueOf(txtPass2.getPassword()).equals("")){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please confirm your Password.");
                    }
                else if(txtPass.getPassword().equals(txtPass2.getPassword())){
                    showMessage(MessageSignUp.MessageType.ERROR, "Please confirm your Password again.");
                    txtPass2.setText("");
                    }
                else{
                    File newUser = new File(importmain.locatData.getAbsolutePath()+"/Teacher/"+txtUser.getText());
                    if (newUser.exists()){
                        showMessage(MessageSignUp.MessageType.ERROR, "This username is already in used.");
                    }else{
                        newUser.mkdir();
                        new Encoder(txtUser.getText(), String.valueOf(txtPass2.getPassword()), txtPhone.getText(), newUser.getAbsolutePath());
                        File history = new File(newUser.getAbsolutePath()+"/HistoryCourse");
                        history.mkdir();
                        try (FileOutputStream fOut = new FileOutputStream(newUser.getAbsolutePath()+"/Body.dat");
                                ObjectOutputStream oOut = new ObjectOutputStream(fOut);){
                            oOut.writeObject(new Option_Login.Account_Teacher(txtUser.getText(), String.valueOf(txtPass2.getPassword()), txtEmail.getText(), txtPhone.getText(), history.getAbsolutePath()));
                            showMessage(MessageSignUp.MessageType.SUCCESS, "Create Your Account completed.");
                        } catch (Exception e) {
                            showMessage(MessageSignUp.MessageType.ERROR, "ERROR.");
                        }
                        setVisible(false);
                        showMessage(MessageSignUp.MessageType.SUCCESS, "Signup complete.");
                    }
                    
                }
            }
        });
        
        register.add(cmd, "w 60%, h 35");
        
        JButton cmd2Forget = new JButton("Cancel");
        cmd2Forget.setForeground(new Color(100, 100, 100));
        cmd2Forget.setFont(new Font("sansserif", 1, 11));
        cmd2Forget.setContentAreaFilled(false);
        cmd2Forget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd2Forget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });
        register.add(cmd2Forget);
        
    }
    
    private void showMessage(MessageSignUp.MessageType messageType, String message) {
        MessageSignUp ms = new MessageSignUp();
        ms.showMessage(messageType, message);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (!ms.isShow()) {
                    register.add(ms, "pos 0.5al -30", 0); //  Insert to bg fist index 0
                    ms.setVisible(true);
                    register.repaint();
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
                register.repaint();
                register.revalidate();
            }

            @Override
            public void end() {
                if (ms.isShow()) {
                    register.remove(ms);
                    register.repaint();
                    register.revalidate();
                } else {
                    ms.setShow(true);
                }
            }
        };
        Animator animator = new Animator(200, target);
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
        
    public void showTeacher(boolean show){
        if (show){
            panelRound.setVisible(true);
            panelRound.setVisible(false);
        }
        else{
            panelRound.setVisible(false);
            panelRound.setVisible(true);
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound = new swing_Login.PanelRound();
        register = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1920, 1080));

        panelRound.setBackground(new java.awt.Color(204, 204, 204));

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(690, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(551, 551, 551))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
   
    protected void paintComponent(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(grphcs);

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_Login.PanelRound panelRound;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables
}
