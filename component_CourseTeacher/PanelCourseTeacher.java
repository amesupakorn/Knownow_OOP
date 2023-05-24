
package component_CourseTeacher;

import Option_Login.Teacher;
import javax.swing.ImageIcon;

public class PanelCourseTeacher extends javax.swing.JPanel implements Teacher{
    String pathimage, pathCourse;
    public PanelCourseTeacher() {
        initComponents();
        
    }
    
    public void setDic(String txt){
        dic.setText(txt);
        dic.setColumns(20);
        dic.setRows(2);
        dic.setEditable(false);
    }
    
    public void setImage(String path, String image){
        this.image.setIcon(new ImageIcon(path+image));
        pathimage = path+image;
        pathCourse = path;
    }
    
    public void backToEmpty(){
        pathimage = null;
        pathCourse = null;
        this.image.setIcon(null);
        dic.setText(null);
        name.setText("Name Course");
    }
    
    public void setNameCourse(String name){
        this.name.setText(name);
    }
    
    public String getNameCourse(){
        return this.name.getText();
    }
    
    public String getDic(){
        return dic.getText();
    }
    
    public ImageIcon getImage(){
        return new ImageIcon(pathimage);
    }
    
    
    public String getPathCourse(){
        return pathCourse;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        dic = new javax.swing.JTextArea();
        course1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(247, 247, 247));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setPreferredSize(new java.awt.Dimension(356, 300));
        image.setRequestFocusEnabled(false);
        add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 20, 360, -1));

        name.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        name.setText("Name Course");
        add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 290, -1));

        dic.setEditable(false);
        dic.setBackground(new java.awt.Color(255, 255, 255));
        dic.setColumns(20);
        dic.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        dic.setRows(5);
        dic.setBorder(null);
        add(dic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 320, 230));

        course1.setBackground(new java.awt.Color(247, 247, 247));
        course1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/component_CourseTeacher/course.png"))); // NOI18N
        add(course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 380, 687));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel course1;
    private javax.swing.JTextArea dic;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    // End of variables declaration//GEN-END:variables
}
