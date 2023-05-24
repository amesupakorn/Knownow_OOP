package main_MenuTeacher;
     

import Option_Login.Account_Teacher;
import Option_Login.SetCourseShow;
import Option_Login.Teacher;
import component_CourseTeacher.AllPanelCourseTeacher;
import component_CourseTeacher.PanelCourseEditTeacher;
import component_CourseTeacher.PanelCourseTeacher;
import component_MenuStudent.ExitStudent;
import component_MenuTeacher.ExitTeacher;
import event_MenuTeacher.EventMenu;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import swing_TeacherCreate.TeacherCreateGUI;
import swing_TeacherCreate.CourseBox;

public class Main_Teacher extends javax.swing.JFrame implements SetCourseShow, Teacher{
    
    public static Account_Teacher nowLoginn = new Account_Teacher();
    public static CourseBox tModel = new CourseBox();
    public static Main_Teacher menuTeacher;
    public static int start; 
    public ArrayList<CourseBox> CourseOwn = new ArrayList<CourseBox>();
    public static ArrayList<CourseBox> jack;
    private AllPanelCourseTeacher panelCourseT;
    
    public Main_Teacher() {
        
        initComponents();
        init();
        
        proTeacher1.user(nowLoginn.getUserName());
        setCourseOwn();
        setCourseGUI(false);
        menuTeacher = this;
        start = 0;
    }
    
    public static void setCourseOwn(){
        jack = new ArrayList<CourseBox>();
        for(int i=0; i<nowLoginn.getOwnCourse().size();i++){
            try (FileInputStream fr = new FileInputStream(nowLoginn.getOwnCourse().get(i)+"/detail.dat");
                ObjectInputStream oout = new ObjectInputStream(fr);){
                jack.add((CourseBox) oout.readObject());
            
                } catch (Exception e) {}
        }

        
    }
    
    public void setCourseGUI(boolean condi){
        CourseOwn = (ArrayList<CourseBox>)jack.clone();
        
        if(!CourseOwn.isEmpty()){
            PanelCourseTeacher[] primaryCourse = panelCourseT.getAllPanel();
            String[] point = new String[3];
            point[0] = primaryCourse[0].getPathCourse();
            point[1] = primaryCourse[1].getPathCourse();
            point[2] = primaryCourse[2].getPathCourse();
            
            //When Delete Course
            if(condi){
                for(int i=0;i<3;i++){
                    if(point[i]==null || point[i].equals(primaryCourse[i].getPathCourse())){
                        primaryCourse[i].backToEmpty();
                    }
                }
                
            }
            
            for(int i=start; i<CourseOwn.size()&&i-start<3;i++){
                primaryCourse[i-start].setImage(nowLoginn.getOwnCourse().get(i), "/picDefault.png");
                
                primaryCourse[i-start].setNameCourse(CourseOwn.get(i).getName());
                
                primaryCourse[i-start].setDic(CourseOwn.get(i).getDecribetion());    
            }  
        }
        else{
            //When Delete and Count to ) Course
            PanelCourseTeacher[] primaryCourse = panelCourseT.getAllPanel();
            
            for(int i=0; i<3;i++){
                primaryCourse[i].backToEmpty();
            }
        }
    }

    private void init(){
        panelCourseT = new AllPanelCourseTeacher();
        
        menuteacher2.initMoving(this);
        
        bg.setLayer(panelCourseT, JLayeredPane.DRAG_LAYER);
        bg.add(panelCourseT);
        panelCourseT.setVisible(true);
        
        menuteacher2.addEventMenu(new EventMenu(){
            @Override //ตกแต่งการเลือกเมนู
            public void menuIndexChange(int index) {
                if(index == 0){
                    
                    panelCourseT.setVisible(true);
                    setCourseOwn();
                    setCourseGUI(false);
                    
                }
                if(index == 1){
                    panelCourseT.setVisible(false);
                    new TeacherCreateGUI().setVisible(true);
                }
                
                else if(index == 9){
                    
                    new ExitTeacher().setVisible(true);
                }
            }
            
            });
    }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuteacher2 = new component_MenuTeacher.Menuteacher();
        bg = new javax.swing.JLayeredPane();
        proTeacher1 = new component_MenuTeacher.ProTeacher();
        heard1 = new component_MenuTeacher.HeardTeacher();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1920, 1080));

        bg.setBackground(new java.awt.Color(247, 247, 247));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout heard1Layout = new javax.swing.GroupLayout(heard1);
        heard1.setLayout(heard1Layout);
        heard1Layout.setHorizontalGroup(
            heard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        heard1Layout.setVerticalGroup(
            heard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 98, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuteacher2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heard1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(proTeacher1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heard1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proTeacher1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(bg))
            .addComponent(menuteacher2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private component_MenuTeacher.HeardTeacher heard1;
    private component_MenuTeacher.Menuteacher menuteacher2;
    private component_MenuTeacher.ProTeacher proTeacher1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setCourseGUI() {}
}
