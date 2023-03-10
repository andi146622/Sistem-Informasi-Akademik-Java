/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugaskelompokpbo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DataMatkul extends javax.swing.JFrame {

    // Membuat variabel untuk datavase
    public Connection conn;
    public ResultSet res;
    public PreparedStatement pst;
    /**
     * Creates new form DataMatkul
     */
    public DataMatkul() {
        initComponents();
        this.conn = Koneksi.configDB();
        load_table();
        showKodeDosen();
        
        txt_nmDosen.setEnabled(false);
    }

     public void load_table(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NO");
        model.addColumn("Kode Mk");
        model.addColumn("Mata KUliah");
        model.addColumn("Kode Dosen");
        model.addColumn("Sks");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from tb_mk";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{no++, res.getString(1),res.getString(2),res.getString(3), res.getString(4)});
            }
            table_mk.setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
     
     public void showKodeDosen(){
         
        try{
            String sql = "SELECT nid FROM tb_dosen";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                c_dosen.addItem(res.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txt_matkul = new javax.swing.JTextField();
        c_dosen = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        btn_tambah4 = new javax.swing.JButton();
        btn_ubah4 = new javax.swing.JButton();
        btn_hapus4 = new javax.swing.JButton();
        btn_clear4 = new javax.swing.JButton();
        btn_kembali4 = new javax.swing.JButton();
        txt_nmDosen = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txt_sks = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_mk = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Mata Kuliah", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24))); // NOI18N

        jLabel18.setText("Kode Mk");

        jLabel19.setText("Mata Kuliah");

        c_dosen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ":. Pilih Koden Dosen .:" }));
        c_dosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dosenActionPerformed(evt);
            }
        });

        jLabel21.setText("Kode Dosen");

        btn_tambah4.setText("Tambah");
        btn_tambah4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambah4MouseClicked(evt);
            }
        });

        btn_ubah4.setText("Ubah");
        btn_ubah4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubah4MouseClicked(evt);
            }
        });

        btn_hapus4.setText("Hapus");
        btn_hapus4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapus4MouseClicked(evt);
            }
        });

        btn_clear4.setText("Clear");
        btn_clear4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clear4MouseClicked(evt);
            }
        });

        btn_kembali4.setText("Kembali");
        btn_kembali4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kembali4MouseClicked(evt);
            }
        });
        btn_kembali4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kembali4ActionPerformed(evt);
            }
        });

        jLabel22.setText("Nama Dosen");

        jLabel20.setText("Sks");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txt_kode))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txt_matkul))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_sks)
                            .addComponent(txt_nmDosen, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c_dosen, 0, 218, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_tambah4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_ubah4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(btn_hapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_clear4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_kembali4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_tambah4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_ubah4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_hapus4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_clear4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 5, Short.MAX_VALUE)
                                .addComponent(txt_sks, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_dosen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)))
                    .addComponent(btn_kembali4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nmDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        table_mk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_mk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_mkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_mk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void c_dosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dosenActionPerformed
        // TODO add your handling code here:
        String dosen = c_dosen.getSelectedItem().toString();
        String nama = "";
        if(dosen.equals(":. Pilih Koden Dosen .:")){
            txt_nmDosen.setText("");
        } else{
            try{
            String sql = "SELECT nama FROM tb_dosen WHERE nid ='"+dosen+"'";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                nama = res.getString(1);
            }
            // tampilkan nama dosen sesuai dengan nid nya
            txt_nmDosen.setText(nama);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_c_dosenActionPerformed

    private void btn_tambah4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambah4MouseClicked
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO tb_mk(`kode_mk`, `mata_kuliah`, `nid`, `sks`)"
            + " VALUES(?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_kode.getText());
            pst.setString(2, txt_matkul.getText());
            pst.setString(3, c_dosen.getSelectedItem().toString());
            pst.setInt(4, Integer.parseInt(txt_sks.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Behasil ditambahkan");
        }catch(Exception e){
            System.out.println(e);
        }
        load_table();
    }//GEN-LAST:event_btn_tambah4MouseClicked

    private void btn_ubah4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubah4MouseClicked
        // TODO add your handling code here:
        try{
            String sql = "UPDATE `tb_mk` SET "
            + "`mata_kuliah`='"+txt_matkul.getText()+"',"
            + "`nid`='"+c_dosen.getSelectedItem().toString()+"',"
            + "`sks`='"+Integer.parseInt(txt_sks.getText())+"' "
            + "WHERE kode_mk ='"+txt_kode.getText()+"'";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Behasil Diubah");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        load_table();
    }//GEN-LAST:event_btn_ubah4MouseClicked

    private void btn_hapus4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus4MouseClicked
        // TODO add your handling code here:
        int p = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin!!!","Hapus",JOptionPane.YES_NO_OPTION);
        if(p == 0){
            try{
                String sql = "DELETE FROM tb_mk WHERE kode_mk ='"+txt_kode.getText()+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Behasil dihapus");
            }catch(Exception e){
                System.out.println(e);
            }
            load_table();
        }
    }//GEN-LAST:event_btn_hapus4MouseClicked

    private void btn_clear4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clear4MouseClicked
        // TODO add your handling code here:
        txt_kode.setText("");
        txt_matkul.setText("");
        c_dosen.setSelectedItem(":. Pilih Koden Dosen .:");
        txt_nmDosen.setText("");
        txt_sks.setText("");
        
        txt_kode.setEnabled(true);
    }//GEN-LAST:event_btn_clear4MouseClicked

    private void btn_kembali4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kembali4MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_kembali4MouseClicked

    private void btn_kembali4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kembali4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_kembali4ActionPerformed

    private void table_mkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_mkMouseClicked
        // TODO add your handling code here:
        // Menampilkan data ke form
        int baris = table_mk.rowAtPoint(evt.getPoint());
        String kode = table_mk.getValueAt(baris, 1).toString();
        txt_kode.setText(kode);
        String matkul = table_mk.getValueAt(baris, 2).toString();
        txt_matkul.setText(matkul);
        String dosen = table_mk.getValueAt(baris, 3).toString();
        c_dosen.setSelectedItem(dosen);
        String sks = table_mk.getValueAt(baris, 4).toString();
        txt_sks.setText(sks);
        
        txt_kode.setEnabled(false);
    }//GEN-LAST:event_table_mkMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DataMatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMatkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMatkul().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear4;
    private javax.swing.JButton btn_hapus4;
    private javax.swing.JButton btn_kembali4;
    private javax.swing.JButton btn_tambah4;
    private javax.swing.JButton btn_ubah4;
    private javax.swing.JComboBox<String> c_dosen;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_mk;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_matkul;
    private javax.swing.JTextField txt_nmDosen;
    private javax.swing.JTextField txt_sks;
    // End of variables declaration//GEN-END:variables
}
