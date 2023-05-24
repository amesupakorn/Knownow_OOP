
package component_CourseTeacher;

import Option_Login.Teacher;
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

public class AllPanelCourseTeacher extends javax.swing.JPanel implements Teacher{

    private PanelCourseEditTeacher edit;
    private PanelCourseTeacher[] panelCourse = {new PanelCourseTeacher(), new PanelCourseTeacher(), new PanelCourseTeacher()};
    public static swing_TeacherCreate.ButtonGradient nextEdit, backEdit;
    
    public AllPanelCourseTeacher() {
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
                main_MenuTeacher.Main_Teacher jum = main_MenuTeacher.Main_Teacher.menuTeacher;
                main_MenuTeacher.Main_Teacher.start = main_MenuTeacher.Main_Teacher.start+1;
                if(main_MenuTeacher.Main_Teacher.start>main_MenuTeacher.Main_Teacher.jack.size()-3){
                    main_MenuTeacher.Main_Teacher.start = main_MenuTeacher.Main_Teacher.jack.size()-3;
                }
                jum.setCourseGUI(false);                                      
            }
        });
        
        backEdit.setText("Back");
        backEdit.setFont(new java.awt.Font("SansSerif", 1, 16)); 
        bg.add(backEdit);
        backEdit.setBounds(20, 760, 120, 50);
        backEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_MenuTeacher.Main_Teacher jum = main_MenuTeacher.Main_Teacher.menuTeacher;
                main_MenuTeacher.Main_Teacher.start = main_MenuTeacher.Main_Teacher.start-1;
                if(main_MenuTeacher.Main_Teacher.start < 0){
                    main_MenuTeacher.Main_Teacher.start = 0;
                }
                jum.setCourseGUI(false);
             }
        });
    }
    
    public void openCourse(){
        for (int i =0;i<3;i++){
            panelCourse[i] = new PanelCourseTeacher();
            bg.add(panelCourse[i]);
            panelCourse[i].setBounds(10+i*(400), 40, 402, 687);
            panelCourse[i].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ev) {
                if(ev.getSource().equals(panelCourse[0])){
                    edit = new PanelCourseEditTeacher(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[0]);
                    
                }else if(ev.getSource().equals(panelCourse[1])){
                    edit = new PanelCourseEditTeacher(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[1]);
                }else if(ev.getSource().equals(panelCourse[2])){
                    edit = new PanelCourseEditTeacher(panelCourse[0], panelCourse[1], panelCourse[2], panelCourse[2]);
                }
                
                bg.add(edit);
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
    public PanelCourseTeacher[] getAllPanel(){
        return panelCourse;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}

