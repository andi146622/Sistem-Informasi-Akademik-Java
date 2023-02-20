/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugaskelompokpbo;

import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DataDosen extends javax.swing.JFrame {

    public Connection conn=null;
    public ResultSet res=null;
    public PreparedStatement pst=null;
    
    private String jenisKelamin;
    private String filename = null;
   
    /**
     * Creates new form DataMahasiswa
     */
    public DataDosen() {
        initComponents();
        this.conn = Koneksi.configDB();
        currentDateTime();
        load_table();
        showidUser();
        enable();
    }
   
    // Menampilkan Waktu saat ini
    public void currentDateTime (){
        
        Calendar cal =new GregorianCalendar();
        int bulan = cal.get(Calendar.MONTH);
        int tahun = cal.get(Calendar.YEAR);
        int hari = cal.get(Calendar.DAY_OF_MONTH);

        text_date.setText(hari+"-"+(bulan+1)+"-"+tahun);
        
        int detik = cal.get(Calendar.SECOND);
        int menit = cal.get(Calendar.MINUTE);
        int jam = cal.get(Calendar.HOUR);
        
        text_time.setText(jam+":"+(menit)+":"+detik);
    }

    private void load_table() {
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("NID");
        model.addColumn("Nama");
        model.addColumn("Tanggal");
        model.addColumn("Tempat");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Alamat");
        model.addColumn("Email");
        model.addColumn("No Hp");
        model.addColumn("Foto");
        
        //menampilkan data database kedalam tabel
        try {
           
            String sql = "select * from tb_dosen order by id_user";
            pst=conn.prepareStatement(sql);
            res=pst.executeQuery();
            while(res.next()){
                model.addRow(new Object[]{res.getString(1), res.getString(2), res.getString(3), 
                    res.getString(4), res.getString(5), res.getString(6), res.getString(7), 
                    res.getString(8), res.getString(9), res.getString(10)});
            }
            table_dosen.setModel(model);
        } catch (Exception e) {
            System.out.println("Gagal : " + e.getMessage());
        }

    }
    
    public void showidUser(){
        try{
            String sql = "SELECT tb_user.id FROM tb_user WHERE "
                        + "tb_user.id NOT IN (SELECT tb_dosen.id_user FROM tb_dosen) "
                        + "AND tb_user.level ='dosen'";
            pst = conn.prepareStatement(sql);
            res = pst.executeQuery();
            while(res.next()){
                c_idUser.addItem(res.getString(1));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
     public void enable(){
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_foto = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_nid = new javax.swing.JTextField();
        txt_tempat = new javax.swing.JTextField();
        r_lakilaki = new javax.swing.JRadioButton();
        r_perempuan = new javax.swing.JRadioButton();
        txt_alamat = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_nohp = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl_gambar = new javax.swing.JLabel();
        btn_tambah = new javax.swing.JButton();
        btn_ubah = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        txt_nama = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        d_tanggal = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        c_idUser = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dosen = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        text_date = new javax.swing.JMenu();
        text_time = new javax.swing.JMenu();

        txt_foto.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Dosen", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Black", 1, 36))); // NOI18N

        jLabel1.setText("NID");

        jLabel2.setText("Nama Lengkap");

        jLabel3.setText("Tanggal Lahir");

        jLabel4.setText("Tempat Lahir");

        jLabel5.setText("Jenis Kelamin");

        jLabel6.setText("Alamat");

        r_lakilaki.setText("Laki-laki");
        r_lakilaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_lakilakiActionPerformed(evt);
            }
        });

        r_perempuan.setText("Perempuan");
        r_perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                r_perempuanActionPerformed(evt);
            }
        });

        jLabel8.setText("No. Hp");

        jLabel9.setText("Email");

        jDesktopPane1.setLayer(lbl_gambar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_gambar, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_gambar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save-icon.png"))); // NOI18N
        btn_tambah.setText("Tambah");
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });

        btn_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update icon.png"))); // NOI18N
        btn_ubah.setText("Ubah");
        btn_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubahMouseClicked(evt);
            }
        });

        btn_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_16x16.gif"))); // NOI18N
        btn_hapus.setText("Hapus");
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });

        btn_clear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase-128.png"))); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clearMouseClicked(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attach.png"))); // NOI18N
        jButton1.setText("Upload Gambar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel12.setText("Id User");

        c_idUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ".: Pilih Id User :." }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nid)
                                    .addComponent(txt_nama)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_alamat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(r_lakilaki, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(r_perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 18, Short.MAX_VALUE))
                                    .addComponent(txt_tempat)
                                    .addComponent(d_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txt_nohp))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_email)
                            .addComponent(c_idUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(btn_ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton1)))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(txt_nama, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tempat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(r_perempuan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(r_lakilaki, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nohp, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c_idUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_ubah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_hapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 147, Short.MAX_VALUE))))
        );

        table_dosen.setModel(new javax.swing.table.DefaultTableModel(
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
        table_dosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dosenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_dosen);

        jButton2.setText("Kembali");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        text_date.setText("Date");
        jMenuBar1.add(text_date);

        text_time.setText("Time");
        jMenuBar1.add(text_time);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_clearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseClicked
        // Menghapus inputan form
        txt_nama.setText("");
        txt_nid.setText("");
        txt_tempat.setText("");
        txt_alamat.setText("");
        txt_nohp.setText("");
        txt_email.setText("");
        d_tanggal.setDate(null);
        r_lakilaki.setSelected(false);
        r_perempuan.setSelected(false);
        lbl_gambar.setIcon(null);
        c_idUser.setSelectedItem(".: Pilih Id User :.");
        
        c_idUser.setEnabled(true);
        txt_nid.setEnabled(true);
        jButton1.setEnabled(true);
        btn_tambah.setEnabled(true);
        enable();
        
    }//GEN-LAST:event_btn_clearMouseClicked

    private void r_lakilakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_lakilakiActionPerformed
        // Jenis kelamin laki-laki
        
        jenisKelamin ="Laki-laki";
        r_lakilaki.setSelected(true);
        r_perempuan.setSelected(false);
        
    }//GEN-LAST:event_r_lakilakiActionPerformed

    private void r_perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_r_perempuanActionPerformed
        // Jenis Kelamin Perempuan
        
        jenisKelamin = "Perempuan";
        r_lakilaki.setSelected(false);
        r_perempuan.setSelected(true);
    }//GEN-LAST:event_r_perempuanActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // Untuk Megupload Gambar
          
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.toString());
            Image img = icon.getImage().getScaledInstance(lbl_gambar.getWidth(), 
                            lbl_gambar.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon iconBaru = new ImageIcon(img);
            lbl_gambar.setIcon(iconBaru);
            this.filename = f.getAbsolutePath();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // Untuk menambahkan Data Mahasiswa
        
        try {
            String newpath = "src/foto";
            // membuat file directory
            File dir = new File(newpath);
            // jika folder directory belum ada
            if(!dir.exists()){
                dir.mkdirs();
            }

            File fileAwal = null;
            File fileAkhir = null;
            // Mendapatkan ekstansi file yang dikirim
            String ext = this.filename.substring(this.filename.lastIndexOf('.')+1);
            // Lokasi tempat awal file gambar berada 
            fileAwal = new File(this.filename);
            // Tempat untuk menyimpan foto/gambar kedalam folder src/foto+nama nim mahasiswa
            fileAkhir = new File(newpath+"/"+txt_nid.getText()+"."+ext);
            
            // Mengubah tanggal
            String tampilan= "yyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tgllahir = String.valueOf(fm.format(d_tanggal.getDate()));
            // mendapatkan id user
            int id = Integer.parseInt(c_idUser.getSelectedItem().toString());
            // Perintah memasukkan foto ke dalam database
            String sql ="INSERT INTO tb_dosen(`id_user`, `nid`, `nama`, `tgllahir`, `tempat`, `jk`, `alamat`, `email`, `nohp`, `foto`)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
               
            pst= conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, txt_nid.getText());
            pst.setString(3, txt_nama.getText());
            pst.setString(4, tgllahir);
            pst.setString(5, txt_tempat.getText());
            pst.setString(6, this.jenisKelamin);
            pst.setString(7, txt_alamat.getText());
            pst.setString(8, txt_email.getText());
            pst.setString(9, txt_nohp.getText());
            pst.setString(10, fileAkhir.toString());
            pst.execute();

            // Mengcopykan file yang dikirim ke dalam folder src/foto
            Files.copy(fileAwal.toPath(), fileAkhir.toPath());

            JOptionPane.showMessageDialog(null,"Data Berhasil ditambahkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }       
        load_table();
        
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void table_dosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dosenMouseClicked
        
        c_idUser.setEnabled(false);
        txt_nid.setEnabled(false);
        jButton1.setEnabled(false);
        btn_tambah.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        // Menampilkan data ke form
        int baris = table_dosen.rowAtPoint(evt.getPoint());
        String nid = table_dosen.getValueAt(baris, 1).toString();
        txt_nid.setText(nid);
        String nama = table_dosen.getValueAt(baris, 2).toString();
        txt_nama.setText(nama);
        String tempat = table_dosen.getValueAt(baris, 4).toString();
        txt_tempat.setText(tempat);
        String alamat = table_dosen.getValueAt(baris, 6).toString();
        txt_alamat.setText(alamat);
        String email = table_dosen.getValueAt(baris, 7).toString();
        txt_email.setText(email);
        String hp = table_dosen.getValueAt(baris, 8).toString();
        txt_nohp.setText(hp);
        
        
        String jk = table_dosen.getValueAt(baris, 5).toString();
        if(jk.equals("Laki-laki")){
           r_lakilaki.setSelected(true);
           r_perempuan.setSelected(false);
        }else {
            r_perempuan.setSelected(true);
            r_lakilaki.setSelected(false);
        }
       
        // menampilkan tanggal 
        DefaultTableModel model = (DefaultTableModel)table_dosen.getModel();
        int seectedRow = table_dosen.getSelectedRow();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(seectedRow, 3).toString());
            d_tanggal.setDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(DataMahasiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Unntuk menampilkan foto 
        String foto = table_dosen.getValueAt(baris, 9).toString();
        ImageIcon icon = new ImageIcon(foto);
        Image img = icon.getImage().getScaledInstance(lbl_gambar.getWidth(), 
                        lbl_gambar.getHeight(), Image.SCALE_DEFAULT);
        ImageIcon iconBaru = new ImageIcon(img);
        lbl_gambar.setIcon(iconBaru);
        txt_foto.setText(foto);
        
    }//GEN-LAST:event_table_dosenMouseClicked

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
        // Untuk mengubah data Dosen
        try{
            // Mengubah tanggal
            String tampilan= "yyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tgllahir = String.valueOf(fm.format(d_tanggal.getDate()));
            
            String sql = "UPDATE `tb_dosen` SET "
                    + "`nama`='"+txt_nama.getText()+"',"
                    + "`tgllahir`='"+tgllahir+"',"
                    + "`tempat`='"+txt_tempat.getText()+"',"
                    + "`jk`='"+jenisKelamin+"',"
                    + "`alamat`='"+txt_alamat.getText()+"',"
                    + "`nohp`='"+txt_nohp.getText()+"',"
                    + "`email`='"+txt_email.getText()+"'"
                    + "WHERE nid='"+txt_nid.getText()+"'";
            pst= conn.prepareStatement(sql);
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Data Berhasil diubah");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        load_table();
    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // Untuk menghapus data mahasiswa
        int p = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin!!!","Hapus",JOptionPane.YES_NO_OPTION);
        // jika tombol yes ditekan maka data akan terhapus
        if(p == 0){
            String sql ="delete from tb_dosen where nid=? ";
            try{
                pst=conn.prepareStatement(sql);
                pst.setString(1, txt_nid.getText());
                pst.execute();

                JOptionPane.showMessageDialog(null,"Data Berhasil dihapus");

            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            load_table();
        }
        
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDosen().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JButton btn_ubah;
    private javax.swing.JComboBox<String> c_idUser;
    private com.toedter.calendar.JDateChooser d_tanggal;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_gambar;
    private javax.swing.JRadioButton r_lakilaki;
    private javax.swing.JRadioButton r_perempuan;
    private javax.swing.JTable table_dosen;
    private javax.swing.JMenu text_date;
    private javax.swing.JMenu text_time;
    private javax.swing.JTextField txt_alamat;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_foto;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_nid;
    private javax.swing.JTextField txt_nohp;
    private javax.swing.JTextField txt_tempat;
    // End of variables declaration//GEN-END:variables
   
}

