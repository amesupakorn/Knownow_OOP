package component_MenuStudent;

import Option_Login.Students;
import component_CourseStudent.AllPanelCourseStudent;
import static component_CourseStudent.AllPanelCourseStudent.backEdit;
import static component_CourseStudent.AllPanelCourseStudent.nextEdit;
import component_CourseStudent.PanelCourseEditStudent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JPopupMenu;
import main_Login.Main;
import swing_MenuStudent.EventCallBack;
import swing_MenuStudent.EventTextField;
import swing_search_MenuStudent.DataSearch;
import swing_search_MenuStudent.EventClick;
import swing_search_MenuStudent.PanelSearch;
import component_CourseStudent.AllPanelCourseStudent;
import component_CourseStudent.PanelCourseStudent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import swing_TeacherCreate.CourseBox;


public class SearchHead extends javax.swing.JPanel implements Students{

    private JPopupMenu menu;
    private PanelSearch search;
    private File[] listFile = Main.locatCourse.listFiles();
    private ArrayList<String> nameList = new ArrayList<String>();
    
    public SearchHead() {
        initComponents();
        setOpaque(false);
        setNameCourse();
        menu = new JPopupMenu();
        search = new PanelSearch();
        menu.setBorder(BorderFactory.createLineBorder(new Color(164, 164, 164)));
        menu.add(search);
        menu.setFocusable(false);
        search.addEventClick(new EventClick(){
            public void itemClick(DataSearch data) {

                menu.setVisible(false);
                txtSearch.setText(data.getText());

                
                //event
                txtSearch.addEvent(new EventTextField(){
                    @Override
                    public void onPressed(EventCallBack call) { //กดปุ่มsearch
                        try {
                            for (int i = 1; i <= 88; i++) {
                                Thread.sleep(10);
                            txtSearch.setText("");
                            menu.setVisible(false);

                            }

                            PanelCourseStudent targetToGo = new PanelCourseStudent();
                            CourseBox targetObject;

                            try (FileInputStream fr = new FileInputStream(main_Login.Main.locatCourse+"/"+data.getText()+"/detail.dat");
                            ObjectInputStream oout = new ObjectInputStream(fr);){
                            targetObject = (CourseBox) oout.readObject();

                            } catch (Exception e) {targetObject = new CourseBox();}
                            File ttget = new File(main_Login.Main.locatCourse+"/"+data.getText());
                            targetToGo.setImage(main_Login.Main.locatCourse+"/"+data.getText(), "/picDefault.png", ttget.getName());

                            targetToGo.setNameCourse(targetObject.getName());

                            targetToGo.setDic(targetObject.getDecribetion()); 
                            AllPanelCourseStudent target = AllPanelCourseStudent.nowAllPanelCourseS;
                            target.edit = new PanelCourseEditStudent(AllPanelCourseStudent.panelCourse[0], AllPanelCourseStudent.panelCourse[1], AllPanelCourseStudent.panelCourse[2], targetToGo);
                            target.bg.add(target.edit);
                            AllPanelCourseStudent.panelCourse[0].setVisible(false);
                            AllPanelCourseStudent.panelCourse[1].setVisible(false);
                            AllPanelCourseStudent.panelCourse[2].setVisible(false);
                            nextEdit.setVisible(false);
                            backEdit.setVisible(false);
                            //ไปหาคอร์ส
                            Thread.sleep(10);
                            call.done();                      
                            txtSearch.setVisible(false); 
                        } catch (Exception e) {
                            System.err.println(e);
                        }

                    }

                    @Override
                    public void onCancel() {
                        
                    }
                });
                System.out.println("Click Item : " + data.getText());
                
            }    
        });
        
        
    }
    public void setTxtSearch(Boolean b){
        txtSearch.setVisible(b);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new swing_search_MenuStudent.SearchText();

        setBackground(new java.awt.Color(255, 255, 255));

        txtSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSearchMouseClicked(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSearchMouseClicked
        if (search.getItemSize() > 0){
            menu.show(txtSearch, 0, txtSearch.getHeight());
        }
    }//GEN-LAST:event_txtSearchMouseClicked
    private void setNameCourse(){
        for(File i : listFile){
            nameList.add(i.getName());
        }
    }
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String text = txtSearch.getText().trim().toLowerCase();
        search.setData(search(text));
        if (search.getItemSize() > 0) {
            //  * 2 top and bot border
            menu.show(txtSearch, 0, txtSearch.getHeight());
            menu.setPopupSize(menu.getWidth(), (search.getItemSize() * 40) + 2);
        } 
        else {
            menu.setVisible(false);
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private List<DataSearch> search(String search){
        int LimitData = 5;
        List<DataSearch> list = new ArrayList<>();
        String dataTesting[] = new String[nameList.size()];
        
        for(int i=0;i<dataTesting.length;i++){
            dataTesting[i] = nameList.get(i);
        }
        
        for (String d : dataTesting){
            if (d.toLowerCase().contains(search)){  //หาคำเหมือน
                list.add(new DataSearch(d));
                if(list.size() == LimitData){
                    break;
                }
            }
        }  
        return list;
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.fillRect(0, 0, 25, getHeight());
        g2.fillRect(getWidth() - 25, getHeight() - 25, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_search_MenuStudent.SearchText txtSearch;
    // End of variables declaration//GEN-END:variables
}
