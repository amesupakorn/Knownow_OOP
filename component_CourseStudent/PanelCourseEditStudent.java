
package component_CourseStudent;

import Option_Login.Account_Student;
import Option_Login.Students;
import component_MenuStudent.SearchHead;
import component_ProfileStudent.AllPanelProStudent;
import java.awt.Desktop;
import java.awt.Label;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import swing_TeacherQuiz.QuizControlStudent;
import table_Student.TableActionEventStu;

public class PanelCourseEditStudent extends javax.swing.JPanel implements Students{

    private PanelCourseStudent course01, course02, course03, showGUI;
    
    
    public PanelCourseEditStudent(PanelCourseStudent back01, PanelCourseStudent back02, PanelCourseStudent back03, PanelCourseStudent show) {
        course01 = back01;
        course02 = back02;
        course03 = back03;
        showGUI = show;
        initComponents();
        setVisible(true);
        init();
        
        //set table model
        TableActionEventStu event = new TableActionEventStu() {
            @Override
            public void onRun(int row) {
                try {
                    
                    Desktop.getDesktop().open(new File(showGUI.getPathCourse()+"/video/"+videoTable.getValueAt(row, 1)));
                    
                } catch (IOException ex) {
                    Logger.getLogger(PanelCourseEditStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        videoTable.fixTable(jScrollPane3);
        videoTable.getColumnModel().getColumn(2).setCellRenderer(new table_Student.TableActionCellRenderStu());
        videoTable.getColumnModel().getColumn(2).setCellEditor(new table_Student.TableActionCellEditorStu(event));
        String localCourse = showGUI.getPathCourse()+"/video";
        
        File checkfolder = new File(localCourse);
        File[] listFileVideo = checkfolder.listFiles();
        int numberrow = listFileVideo.length;
        DefaultTableModel mod = (DefaultTableModel) videoTable.getModel();
        for (int i=0;i<numberrow;i++){
            mod.addRow(new Object[]{i, listFileVideo[i].getName()});
            }
        
        //set Histtory
        AllPanelProStudent.nowHistory.updatHistory(showGUI.getNameFolder());
        
    } 
    
    
    private void init(){
        image.setIcon(showGUI.getImage());
        nameCourse.setText(nameCourse.getText()+" "+showGUI.getNameCourse());
        Describtion.setText(showGUI.getDic());
        Describtion.setEditable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameCourse = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Describtion = new javax.swing.JTextArea();
        image = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        videoTable = new table_Student.TableStudent();
        create = new swing_TeacherCreate.ButtonGradient();

        setBackground(new java.awt.Color(247, 247, 247));
        setPreferredSize(new java.awt.Dimension(1500, 1000));
        setRequestFocusEnabled(false);
        setSize(new java.awt.Dimension(1500, 1000));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCourse.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        nameCourse.setText("Name Couse :");
        add(nameCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 360, 50));

        Describtion.setColumns(20);
        Describtion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Describtion.setRows(5);
        jScrollPane1.setViewportView(Describtion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 360, 230));
        add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 420, 300));

        back.setBackground(new java.awt.Color(247, 247, 247));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component_CourseStudent/back.png"))); // NOI18N
        back.add(jLabel1);

        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        videoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Number", "Name", "Play Video"
            }
        ));
        jScrollPane3.setViewportView(videoTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 810, 380));

        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/1.png"))); // NOI18N
        create.setText("Quiz");
        create.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 350, 130, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        course01.setVisible(true);
        course02.setVisible(true);
        course03.setVisible(true);
        AllPanelCourseStudent.backEdit.setVisible(true);
        AllPanelCourseStudent.nextEdit.setVisible(true);
        main_MenuStudent.main_Student.searchHead2.setTxtSearch(true);
        setVisible(false);
        
    }//GEN-LAST:event_backMouseClicked

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        new QuizControlStudent(showGUI.getPathCourse()).setVisible(true);
    }//GEN-LAST:event_createActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Describtion;
    private javax.swing.JPanel back;
    private swing_TeacherCreate.ButtonGradient create;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameCourse;
    private table_Student.TableStudent videoTable;
    // End of variables declaration//GEN-END:variables
}
