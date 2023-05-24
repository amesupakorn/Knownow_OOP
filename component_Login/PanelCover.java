package component_Login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import swing_Login.ButtonOutLine;

public class PanelCover extends javax.swing.JPanel {
        
    private final DecimalFormat df=new DecimalFormat("##0.###");
    private ActionListener event;
    private MigLayout layout;
    private JLabel title, icon;
    private JLabel description;
    private JLabel description1;
    private ButtonOutLine button;
    private boolean isLogin;

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap, fill", "[center]", "push[]25[]10[]10[]25[]push");
        setLayout(layout);
        init();
    }
    
    private void init(){
        icon = new JLabel(new ImageIcon(getClass().getResource("/icon/logo.png")));
        add(icon);
        title = new JLabel("KNOWNOW!");
        title.setFont(new Font("sansserif", 1, 35));
        title.setForeground(new Color(245, 245, 245));
        add(title);
        description = new JLabel("Glad you got some knowledge back.");
        description.setFont(new Font("sansserif", 1, 12));
        description.setForeground(new Color(245, 245, 245));
        add(description);
        description1 = new JLabel("Wherever you are, you can gain knowledge.");
        description1.setFont(new Font("sansserif", 1, 12));
        description1.setForeground(new Color(245, 245, 245));
        add(description1);
        button = new ButtonOutLine();
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(255, 255, 255));
        button.setText("Teacher Account");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.actionPerformed(ae);            
            }
        });
        add(button, "w 60%, h 40");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(43, 61, 242), 0, getHeight(), new Color(116, 37, 228));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    
    public void addEvent(ActionListener event) {
        this.event = event;
        
    }
    
    public void teacherLeft(double v) {
        v = Double.valueOf(df.format(v));
        student(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
        
    }
    public void teacherRight(double v) {
        v = Double.valueOf(df.format(v));
        student(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(description1, "pad 0 -" + v + "% 0 0");
    }

    
    public void studentLeft(double v){
        v = Double.valueOf(df.format(v));
        student(true);
        
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void studentRight(double v){
        v = Double.valueOf(df.format(v));
        student(true);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(description1, "pad 0 " + v + "% 0 " + v + "%");
    }
    
    public void student(boolean student){
        if (this.isLogin != student) {
            if (student) {
                title.setText("Hello, Teacher!");
                description.setText("Thank you for educating them.");
                description1.setText("Even if you don't know them.");
                button.setText("Student Accounts");
            } 
            else {
                title.setText("KNOWNOW!");
                description.setText("Glad you got some knowledge back.");
                description1.setText("Wherever you are, you can gain knowledge.");
                button.setText("Teacher Accounts");
            }
            this.isLogin = student;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
