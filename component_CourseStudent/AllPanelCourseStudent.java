
package component_CourseStudent;

import Option_Login.Students;
import component_ProfileStudent.AllPanelProStudent;
import java.awt.Desktop;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.DebugGraphics;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class AllPanelCourseStudent extends javax.swing.JPanel implements Students{

    public PanelCourseEditStudent edit;
    public static PanelCourseStudent[] panelCourse = {new PanelCourseStudent(), new PanelCourseStudent(), new PanelCourseStudent()};
    public static swing_TeacherCreate.ButtonGradient nextEdit, backEdit;
    public static AllPanelCourseStudent nowAllPanelCourseS;
    
    public AllPanelCourseStudent() {
        nowAllPanelCourseS = this;
        nextEdit = new swing_TeacherCreate.ButtonGradient();
        backEdit = new swing_TeacherCreate.ButtonGradient();
        
        initComponents();
        init();
        openCourse();
    }
    
    private void init(){
        nextEdit.setText("Next");
        nextEdit.setFont(new java.awt.Font("SansSerif", 1, 16)); 
        bg.add(nextEdit);
        nextEdit.setBounds(1030, 760, 120, 50);
        nextEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_MenuStudent.main_Student jum = main_MenuStudent.main_Student.menuStudent;
                main_MenuStudent.main_Student.start = main_MenuStudent.main_Student.start+1;
                if(main_MenuStudent.main_Student.start>main_MenuStudent.main_Student.alreadyToShowCourse.size()-3){
                    main_MenuStudent.main_Student.start = main_MenuStudent.main_Student.alreadyToShowCourse.size()-3;
                }
                jum.setCourseGUI();                                      
            }
        });
        
        backEdit.setText("Back");
        backEdit.setFont(new java.awt.Font("SansSerif", 1, 16)); 
        bg.add(backEdit);
        backEdit.setBounds(20, 760, 120, 50);
        backEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_MenuStudent.main_Student jum = main_MenuStudent.main_Student.menuStudent;
                main_MenuStudent.main_Student.start = main_MenuStudent.main_Student.start-1;
                if(main_MenuStudent.main_Student.start < 0){
                    main_MenuStudent.main_Student.start = 0;
                }
                jum.setCourseGUI();
             }
        });
        
    }
    
    public void openCourse(){
        for (int i =0;i<3;i++){
            panelCourse[i] = new PanelCourseStudent();
            bg.add(panelCourse[i]);
            panelCourse[i].setBounds(10+i*(400), 40, 402, 687);
            panelCourse[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                
                if(ev.getSource().equals(panelCourse[0])){
                    edit = new PanelCourseEditStudent(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[0]);
                    
                }else if(ev.getSource().equals(panelCourse[1])){
                    edit = new PanelCourseEditStudent(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[1]);
                
                }else if(ev.getSource().equals(panelCourse[2])){
                    edit = new PanelCourseEditStudent(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[2]);
                
                }
                
                bg.add(edit);
                main_MenuStudent.main_Student.searchHead2.setTxtSearch(false);
                
                //udate History
                
                
                panelCourse[0].setVisible(false);
                panelCourse[1].setVisible(false);
                panelCourse[2].setVisible(false);
                nextEdit.setVisible(false);
                backEdit.setVisible(false);
            }
            
        });
        }
        
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setBackground(new java.awt.Color(247, 247, 247));
        setPreferredSize(new java.awt.Dimension(1300, 900));
        setSize(new java.awt.Dimension(1300, 900));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 840));
    }// </editor-fold>//GEN-END:initComponents
    public PanelCourseStudent[] getAllPanel(){
        return panelCourse;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

