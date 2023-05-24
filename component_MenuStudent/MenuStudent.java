package component_MenuStudent;

import Option_Login.Students;
import event_MenuStudent.EventMenu;
import event_MenuStudent.EventMenuCallBack;
import event_MenuStudent.EventMenuSelected;
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
import swing_MenuStudent.Model_MenuStudent;

public class MenuStudent extends javax.swing.JPanel implements Students{
    
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
    
    public MenuStudent() {
//        menuExit1.setVisible(false);
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        listMenu.addEventSelectedMenu(new EventMenuSelected(){
            
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if(index != selectedIndex){
                    MenuStudent.this.callBack = callBack;
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
                    menuYTarget = selectedIndex * 57 + listMenu.getY();
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
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("1", "HOME", Model_MenuStudent.MenuType.MENU));
        listMenu.addItem(new Model_MenuStudent("2", "MYCOURSE", Model_MenuStudent.MenuType.MENU));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("", "", Model_MenuStudent.MenuType.EMPTY));
        listMenu.addItem(new Model_MenuStudent("4", "LOGOUT", Model_MenuStudent.MenuType.MENU));
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        listMenu = new swing_MenuStudent.ListMenuStudent<>();
        panelMoving = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add(listMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 286, 820));

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
                .addGroup(panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMovingLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMovingLayout.setVerticalGroup(
            panelMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMovingLayout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        add(panelMoving, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private swing_MenuStudent.ListMenuStudent<String> listMenu;
    private javax.swing.JPanel panelMoving;
    // End of variables declaration//GEN-END:variables
}
