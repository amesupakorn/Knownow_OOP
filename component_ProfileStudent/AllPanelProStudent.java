package component_ProfileStudent;

import Option_Login.Students;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import main_MenuStudent.main_Student;

public class AllPanelProStudent extends javax.swing.JPanel implements Students{
    
    private ArrayList<String> historyAlreadyToShow = new ArrayList<String>();
    private HistoryObject boxShow;
    public static AllPanelProStudent nowHistory;
    
    public AllPanelProStudent() {
        nowHistory = this;
        initComponents();
        init();
        try (FileInputStream fr = new FileInputStream(main_Login.Main.locatUserLogin.getAbsolutePath()+"/"+main_Student.nowLogin.getUserName()+"/HistoryCourse/data.dat");
                ObjectInputStream oout = new ObjectInputStream(fr);){
            boxShow = (HistoryObject) oout.readObject();
            
        } catch (Exception e) {
            boxShow = new HistoryObject();
        }
        
        DefaultTableModel model = (DefaultTableModel) tableH1.getModel();
        
        for(Object[] row: boxShow){
            model.addRow((Object[]) row);
        }
    }
    
    public void updatHistory(String name){
        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        Object[] newRow = new Object[]{dtf.format(LocalDateTime.now()), name};
        
        DefaultTableModel model = (DefaultTableModel) tableH1.getModel();
        model.addRow(newRow);
        boxShow.add(newRow);
        
        try (FileOutputStream fr = new FileOutputStream(main_Login.Main.locatUserLogin.getAbsolutePath()+"/"+main_Student.nowLogin.getUserName()+"/HistoryCourse/data.dat");
                ObjectOutputStream oout = new ObjectOutputStream(fr);){
            oout.writeObject(boxShow);
            
        } catch (Exception e) {
        }
    }
    
    private void init(){
        tableH1.fixTable(jScrollPane1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();
        view1 = new component_ProfileStudent.ViewStudent();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableH1 = new table_StudentHis.TableHistory();

        setBackground(new java.awt.Color(247, 247, 247));
        setPreferredSize(new java.awt.Dimension(1300, 900));
        setRequestFocusEnabled(false);
        setSize(new java.awt.Dimension(1300, 900));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableH1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Time", "Course"
            }
        ));
        tableH1.setEnabled(false);
        jScrollPane1.setViewportView(tableH1);

        bg.setLayer(view1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        bg.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(view1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(593, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(view1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 820));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    private javax.swing.JScrollPane jScrollPane1;
    private table_StudentHis.TableHistory tableH1;
    public static component_ProfileStudent.ViewStudent view1;
    // End of variables declaration//GEN-END:variables
}
