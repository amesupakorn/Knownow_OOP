package component_MenuTeacher;

import Option_Login.Teacher;
import event_MenuTeacher.EventMenu;
import event_MenuTeacher.EventMenuCallBack;
import event_MenuTeacher.EventMenuSelected;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Path2D;
import javax.swing.JFrame;
import javax.swing.Timer;
import swing_MenuTeacher.Model_MenuTeacher;

public class Menuteacher extends javax.swing.JPanel implements Teacher{
 
  public void addEventMenu(EventMenu event){
        this.event = event;
    }
    
    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp ;
    private int menuYTarget;
    int menuY;
    private int speed = 2;
    private EventMenuCallBack callBack;
    private EventMenu event;
    
    public Menuteacher() {
//        menuExit1.setVisible(false);
        initComponents();
        setOpaque(false);
        listMenu1.setOpaque(false);
        listMenu1.addEventSelectedMenu(new EventMenuSelected(){
            
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if(index != selectedIndex){
                    Menuteacher.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if(selectedIndex == -1){
                        speed = 20;
                    }
                    else{      
                        speed = selectedIndex - index;
                        if(speed < 0){
                            speed *= -1;
                        }
                    }
                    speed++;
                    selectedIndex = index;
                    menuYTarget = selectedIndex * 57 + listMenu1.getY();
                    if(!timer.isRunning()){
                        timer.start();
                    }
                }  
            }
                
           
        });
        timer = new Timer(0, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(toUp){
                    if(menuY <= menuYTarget - 10){
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if(event != null){
                            event.menuIndexChange(selectedIndex);
                        }
                    }
                    else{
                        menuY -= speed;
                        repaint();
                    }
                }
                else{
                    if(menuY >= menuYTarget + 10){
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if(event != null){
                            event.menuIndexChange(selectedIndex);
                        }
                    }
                    else{
                        menuY += speed;
                        repaint();
                    }
                            
                }
            }
             
        });
        initData();
        
    }
    
    private void initData() {
        listMenu1.addItem(new Model_MenuTeacher("1", "COURSE", Model_MenuTeacher.MenuType.MENU));
        listMenu1.addItem(new Model_MenuTeacher("2", "CREATE", Model_MenuTeacher.MenuType.MENU));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("", "", Model_MenuTeacher.MenuType.EMPTY));
        listMenu1.addItem(new Model_MenuTeacher("4", "LOGOUT", Model_MenuTeacher.MenuType.MENU));
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        heard1 = new component_MenuTeacher.HeardTeacher();
        panelMoving = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        listMenu1 = new swing_MenuTeacher.ListMenuTeacher<>();

        javax.swing.GroupLayout heard1Layout = new javax.swing.GroupLayout(heard1);
        heard1.setLayout(heard1Layout);
        heard1Layout.setHorizontalGroup(
            heard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        heard1Layout.setVerticalGroup(
            heard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelMoving.setOpaque(false);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KNOWNOW");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout panelMovingLayout = new javax.swing.GroupLayout(panelMoving);
        panelMoving.setLayout(panelMovingLayout);
        panelMovingLayout.setHorizontalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMovingLayout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMoving, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(listMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#2B3DF2"), 0, getHeight(), Color.decode("#8925E4"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        if(selectedIndex >= 0){
            int menuX = 25;
            int height = 50;
            int width = getWidth();
            g2.setColor(new Color(242, 242, 242));
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width - 30, menuY);
            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
            g2.fill(f);
        }
        super.paintComponent(grphcs);
    }
    private int x;
    private int y;
    
    public void initMoving(JFrame fram){
        panelMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me){
                x = me.getX();
                y = me.getY();
            }
                    
        });
        panelMoving.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent me){
                fram.setLocation(me.getXOnScreen() - x, me.getYOnScreen() - y);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component_MenuTeacher.HeardTeacher heard1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private swing_MenuTeacher.ListMenuTeacher<String> listMenu1;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}



