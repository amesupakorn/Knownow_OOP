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
import main_Login.Main;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import swing_Login.Button;
import swing_Login.MyPasswordField;
import swing_Login.MyTextField;

public class PanelVertify extends javax.swing.JPanel {
    
    private MigLayout layout;
    private main_Login.Main importmain;//Use static vairable is loacatUserLogin of class main
    private MyPasswordField txtPass = new MyPasswordField();
    private static main_Login.Main m;
    
    public PanelVertify(ActionListener eventRegisterTeacher) {
        initComponents();
        initRegister(eventRegisterTeacher);
        setOpaque(false);
        setFocusCycleRoot(true);
        super.setVisible(false);
        addMouseListener(new MouseAdapter() {
        });
        register.setVisible(true);
    }
    
    private void initRegister(ActionListener eventRegisterTeacher){
        layout = new MigLayout("fill, insets 0");
        
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]15[]10[]push"));
        JLabel label = new JLabel("Vertify Code");
        label.setFont(new Font("sansserif", 1, 35));
        label.setForeground(new Color(29, 20, 180));
        register.add(label);
        
      
        txtPass.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        txtPass.setHint("Password");
        register.add(txtPass, "w 95%");
        
        Button cmd = new Button();
        cmd.setBackground(new Color(29, 20, 180));
        cmd.setForeground(new Color(250, 250, 250));
        cmd.setText("SIGN UP");
        
        cmd.addActionListener(eventRegisterTeacher);
        
//        if(m.registerTeacher() == false){
//            showMessage(Message1.MessageType.ERROR, "Please enter your Password.");
//        }
//        else{
//            showMessage(Message1.MessageType.ERROR, "Please enter your Password.");
//        }
        
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
    
    public String getPass(){
        return String.valueOf(txtPass.getPassword());
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
            .addGap(0, 830, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 212, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelRoundLayout = new javax.swing.GroupLayout(panelRound);
        panelRound.setLayout(panelRoundLayout);
        panelRoundLayout.setHorizontalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoundLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        panelRoundLayout.setVerticalGroup(
            panelRoundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoundLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(402, Short.MAX_VALUE)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(526, 526, 526))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(panelRound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(590, Short.MAX_VALUE))
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
