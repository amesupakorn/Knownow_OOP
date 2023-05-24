
package component_CourseTeacher;

import Option_Login.Account_Teacher;
import Option_Login.Teacher;
import java.awt.Desktop;
import java.awt.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import table_Teacher.TableActionCellEditorTea;
import table_Teacher.TableActionCellRenderTea;
import main_MenuTeacher.Main_Teacher;
import swing_TeacherCreate.CourseBox;
import swing_TeacherQuiz.QuizControlTeacher;
import table_Teacher.TableActionEventTea;

public class PanelCourseEditTeacher extends javax.swing.JPanel implements Teacher{

    public static Account_Teacher nowLoginn = new Account_Teacher();
    private PanelCourseTeacher course01, course02, course03, showGUI;
    
    
    public PanelCourseEditTeacher(PanelCourseTeacher back01, PanelCourseTeacher back02, PanelCourseTeacher back03, PanelCourseTeacher show) {
        course01 = back01;
        course02 = back02;
        course03 = back03;
        showGUI = show;

        initComponents();
        setVisible(true);
        init();
        
        //set table model
        TableActionEventTea event = new TableActionEventTea() {
            
            @Override
            public void onRun(int row) {
                try {
                    
                    Desktop.getDesktop().open(new File(showGUI.getPathCourse()+"/video/"+videoTable.getValueAt(row, 1)));
                    
                } catch (IOException ex) {
                    Logger.getLogger(PanelCourseEditTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            public void onDelete(int row){
                if(videoTable.isEditing()){
                    videoTable.getCellEditor().stopCellEditing();
                }
                File target = new File(showGUI.getPathCourse()+"/video/"+videoTable.getValueAt(row, 1));
                target.delete();
                DefaultTableModel model = (DefaultTableModel) videoTable.getModel();
                model.removeRow(row);
            }
        };
        videoTable.fixTable(jScrollPane3);
        videoTable.getColumnModel().getColumn(2).setCellRenderer(new TableActionCellRenderTea());
        videoTable.getColumnModel().getColumn(2).setCellEditor(new TableActionCellEditorTea(event));
        String localCourse = showGUI.getPathCourse()+"/video";
        File checkfolder = new File(localCourse);
        File[] listFileVideo = checkfolder.listFiles();
        if(listFileVideo == null){
            listFileVideo = new File[0];
        }
        int numberrow = listFileVideo.length;
        DefaultTableModel mod = (DefaultTableModel) videoTable.getModel();
        for (int i=0;i<numberrow;i++){
           mod.addRow(new Object[]{i, listFileVideo[i].getName()});
        }
        
    }
    
    private void init(){
        image.setIcon(showGUI.getImage());
        nameCourse.setText(nameCourse.getText()+" "+showGUI.getNameCourse());
        Describtion.setText(showGUI.getDic());
    }
    
    public PanelCourseTeacher getCourse(){
        return showGUI;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameCourse = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Describtion = new javax.swing.JTextArea();
        editCourse = new swing_TeacherCreate.ButtonGradient();
        deleteCourse = new swing_TeacherCreate.ButtonGradient();
        image = new javax.swing.JLabel();
        back = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        create = new swing_TeacherCreate.ButtonGradient();
        jScrollPane3 = new javax.swing.JScrollPane();
        videoTable = new table_Teacher.TableTeacher();
        uploadCourse1 = new swing_TeacherCreate.ButtonGradient();

        setBackground(new java.awt.Color(247, 247, 247));
        setPreferredSize(new java.awt.Dimension(1500, 1000));
        setRequestFocusEnabled(false);
        setSize(new java.awt.Dimension(1500, 1000));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameCourse.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        nameCourse.setText("Name Couse :");
        add(nameCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 360, 50));

        Describtion.setColumns(20);
        Describtion.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        Describtion.setRows(5);
        jScrollPane1.setViewportView(Describtion);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 360, 240));

        editCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/edit.png"))); // NOI18N
        editCourse.setText("Edit");
        editCourse.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        editCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCourseActionPerformed(evt);
            }
        });
        add(editCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 120, 50));

        deleteCourse.setBackground(new java.awt.Color(255, 0, 51));
        deleteCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/table_Teacher/delete.png"))); // NOI18N
        deleteCourse.setText("Delete Course");
        deleteCourse.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        deleteCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteCourseMousePressed(evt);
            }
        });
        add(deleteCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 750, 200, 50));

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component_CourseTeacher/photo.png"))); // NOI18N
        add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 400, 300));

        back.setBackground(new java.awt.Color(247, 247, 247));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component_CourseTeacher/back.png"))); // NOI18N
        back.add(jLabel1);

        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/1.png"))); // NOI18N
        create.setText("My Quiz");
        create.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 180, 50));

        videoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Number", "Name", "Tools"
            }
        ));
        jScrollPane3.setViewportView(videoTable);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 420, 800, 310));

        uploadCourse1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconTeacher/up.png"))); // NOI18N
        uploadCourse1.setText("Upload Video");
        uploadCourse1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        uploadCourse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                uploadCourse1MousePressed(evt);
            }
        });
        uploadCourse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadCourse1ActionPerformed(evt);
            }
        });
        add(uploadCourse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 180, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void deleteCourseMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteCourseMousePressed
        Account_Teacher ta = Main_Teacher.nowLoginn;
        ta.getOwnCourse().remove(showGUI.getPathCourse());
        try (FileOutputStream fr = new FileOutputStream(component_Login.PanelLogin.nowInUse+"/Body.dat");
            ObjectOutputStream oout = new ObjectOutputStream(fr);){
            oout.writeObject(ta);
            
        } catch (Exception e) {
            System.out.println("Can't Delete");
        }
        deleteFolder(new File(showGUI.getPathCourse()));
        
        Main_Teacher.setCourseOwn();
        Main_Teacher.menuTeacher.setCourseGUI(true);
        course01.setVisible(true);
        course02.setVisible(true);
        course03.setVisible(true);
        AllPanelCourseTeacher.backEdit.setVisible(true);
        AllPanelCourseTeacher.nextEdit.setVisible(true);
        
        setVisible(false);
    }//GEN-LAST:event_deleteCourseMousePressed

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        course01.setVisible(true);
        course02.setVisible(true);
        course03.setVisible(true);
        AllPanelCourseTeacher.backEdit.setVisible(true);
        AllPanelCourseTeacher.nextEdit.setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_backMouseClicked

    private void editCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCourseActionPerformed
        CourseBox wantEdit = new CourseBox();
        try (FileInputStream fr = new FileInputStream(showGUI.getPathCourse()+"/detail.dat");
            ObjectInputStream oout = new ObjectInputStream(fr);){
            wantEdit = (CourseBox)oout.readObject();
        } catch (Exception e) {}
        wantEdit.setDecribetion(Describtion.getText());
        try (FileOutputStream fr = new FileOutputStream(showGUI.getPathCourse()+"/detail.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fr);){
            oout.writeObject(wantEdit);
        } catch (Exception e) {}
        Main_Teacher.setCourseOwn();
        Main_Teacher.menuTeacher.setCourseGUI(false);
    }//GEN-LAST:event_editCourseActionPerformed

    private void uploadCourse1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadCourse1MousePressed

    }//GEN-LAST:event_uploadCourse1MousePressed

    private void uploadCourse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadCourse1ActionPerformed
        new swing_TeacherCreate.Teach_Upload_Video(showGUI.getPathCourse()+"/video", videoTable).setVisible(true);
    }//GEN-LAST:event_uploadCourse1ActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        new QuizControlTeacher(showGUI.getPathCourse()).setVisible(true);
    }//GEN-LAST:event_createActionPerformed
    public void deleteFolder(File source){
        File[] target = source.listFiles();
        for(File i:target){
            if(i.isDirectory()){
                deleteFolder(i);
            }
            i.delete();
        }
        source.delete();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Describtion;
    private javax.swing.JPanel back;
    private swing_TeacherCreate.ButtonGradient create;
    private swing_TeacherCreate.ButtonGradient deleteCourse;
    private swing_TeacherCreate.ButtonGradient editCourse;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel nameCourse;
    private swing_TeacherCreate.ButtonGradient uploadCourse1;
    private table_Teacher.TableTeacher videoTable;
    // End of variables declaration//GEN-END:variables
}
