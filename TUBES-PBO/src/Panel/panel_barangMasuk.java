package Panel;

import Data.data_barang;
import Koneksi.koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Utama.frm_utama;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leily
 */
public class panel_barangMasuk extends javax.swing.JPanel {

    koneksi dbsetting;
    String driver,database,user,pass;
    /**
     * Creates new form panel_barangMasuk
     */
    public panel_barangMasuk(String role) {
        initComponents();
        Date now = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        txt_kodeMasuk.setText(generateCode());
        txt_tanggalPesan.setText(tanggal.format(now));
        tabel_sementara.setModel(tableModel);
        btn_hapusdata.setEnabled(false);
        btn_cleardata.setEnabled(false);
        btn_tambahbarang.setEnabled(false);
        btn_simpanbarang.setEnabled(false);
        settableload();
        if (tableModel.getRowCount() > 0) {
            btn_simpanbarang.setEnabled(true);
        }
    }

    private javax.swing.table.DefaultTableModel tableModel = getDefaultTableModel();
    private javax.swing.table.DefaultTableModel getDefaultTableModel(){
        return new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Kode Masuk","Kode Barang","Harga Barang","Jumlah Pesan", "Subtotal"}
        )
        {
            boolean[] canEdit = new boolean[]{
                false,false,false,false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex){
                return canEdit[columnIndex];
            }
        };
    }
    
    String data[] = new String[6];
    private void settableload() {
        long totharga = 0;
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM detail_transaksi WHERE `TRANSAKSI_ID` = '"+txt_kodeMasuk.getText()+"' AND `STATUS` = '1'";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0] = res.getString(2);                
                data[1] = res.getString(6);
                data[2] = res.getString(7);              
                data[3] = res.getString(8);
                data[4] = res.getString(9);
                tableModel.addRow(data);
                totharga = totharga + Long.parseLong(data[4]);
            }
            res.close();
            stt.close();
            kon.close();
            lb_totharga.setText(String.valueOf(totharga));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void clearForm(){
        txt_kodeBarang.setText("");
        txt_namaBarang.setText("");
        txt_hargaBarang.setText("");
        txt_jumlahBarang.setText("");
        txt_subtotalBarang.setText("");
    }
    
    String newID;
    public String generateCode() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL2 = "SELECT COUNT(*) FROM transaksi_outcome";
            int rowCount;
            try (ResultSet countrs = stt.executeQuery(SQL2)) {
                countrs.next();
                rowCount = countrs.getInt(1);
            }
            // Generate the ID with leading zeros
            DecimalFormat idFormat = new DecimalFormat("000");
            newID = "MB" + idFormat.format(rowCount + 1);
        } catch (Exception e) {
            System.out.println("");
        }
        return newID;
    }
    
    private void Barang_Masuk() {
        int rowCount = tabel_sementara.getRowCount();
        String kode;
        int tot_jumlah = 0;
        for (int i = 0; i < rowCount; i++){
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                kode = tabel_sementara.getValueAt(i, 1).toString();
                int jumlah = Integer.parseInt(tabel_sementara.getValueAt(i, 3).toString());
                String SQL = "SELECT `JUMLAH` FROM `barang` WHERE `ID` = '"+kode+"'";
                ResultSet rs = stt.executeQuery(SQL);
                while (rs.next()){
                    int tersedia = rs.getInt("JUMLAH");
                    tot_jumlah = jumlah + tersedia;
                }
                String SQL1 = "UPDATE `barang` SET `JUMLAH` = '"+tot_jumlah+"' WHERE `ID` = '"+kode+"'";
                stt.executeUpdate(SQL1);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
            }
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

        jLabel1 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kodeMasuk = new javax.swing.JTextField();
        txt_tanggalPesan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_kodeBarang = new javax.swing.JTextField();
        btn_ambilBarang = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_namaBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_hargaBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_jumlahBarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_subtotalBarang = new javax.swing.JTextField();
        btn_tambahbarang = new rojerusan.RSMaterialButtonRectangle();
        btn_cleardata = new rojerusan.RSMaterialButtonRectangle();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lb_totharga = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_sementara = new javax.swing.JTable();
        btn_simpanbarang = new rojerusan.RSMaterialButtonRectangle();
        btn_hapusdata = new rojerusan.RSMaterialButtonRectangle();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("PEMBELIAN BARANG");

        kGradientPanel1.setkEndColor(new java.awt.Color(37, 59, 80));
        kGradientPanel1.setkStartColor(new java.awt.Color(58, 135, 200));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Kode Masuk");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Tanggal");

        txt_kodeMasuk.setEditable(false);

        txt_tanggalPesan.setEditable(false);

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_kodeMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodeMasuk, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        jPanel3.setBackground(new java.awt.Color(37, 59, 80));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("BARANG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
        );

        jLabel5.setText("Kode Barang");

        txt_kodeBarang.setEditable(false);

        btn_ambilBarang.setText("...");
        btn_ambilBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ambilBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Barang");

        txt_namaBarang.setEditable(false);

        jLabel7.setText("Harga");

        jLabel8.setText("Jumlah");

        txt_jumlahBarang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlahBarangKeyReleased(evt);
            }
        });

        jLabel9.setText("Subtotal");

        txt_subtotalBarang.setEditable(false);

        btn_tambahbarang.setText("Tambah Barang");
        btn_tambahbarang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_tambahbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahbarangActionPerformed(evt);
            }
        });

        btn_cleardata.setBackground(new java.awt.Color(255, 51, 51));
        btn_cleardata.setText("Hapus Data");
        btn_cleardata.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_cleardata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleardataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_namaBarang)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_ambilBarang))
                    .addComponent(txt_hargaBarang)
                    .addComponent(txt_jumlahBarang)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txt_subtotalBarang)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_cleardata, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_tambahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ambilBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_jumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_subtotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_tambahbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cleardata, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(37, 59, 80));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Pesan");

        lb_totharga.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_totharga.setForeground(new java.awt.Color(255, 255, 255));
        lb_totharga.setText("Total Pesan");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(lb_totharga, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lb_totharga))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabel_sementara.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_sementara.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_sementaraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_sementara);

        btn_simpanbarang.setText("Simpan");
        btn_simpanbarang.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_simpanbarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanbarangActionPerformed(evt);
            }
        });

        btn_hapusdata.setBackground(new java.awt.Color(255, 0, 51));
        btn_hapusdata.setText("Hapus");
        btn_hapusdata.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_hapusdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusdataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 159, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_simpanbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_hapusdata, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_hapusdata, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_simpanbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(203, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ambilBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ambilBarangActionPerformed
        // TODO add your handling code here:
        data_barang dataBarang = new data_barang(null,true);
        dataBarang.setVisible(true);
        txt_kodeBarang.setText(dataBarang.getKodeBarang());
        txt_namaBarang.setText(dataBarang.getNamaBarang());
        btn_tambahbarang.setEnabled(true);
        btn_cleardata.setEnabled(true);
    }//GEN-LAST:event_btn_ambilBarangActionPerformed

    private void txt_jumlahBarangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlahBarangKeyReleased
        // TODO add your handling code here:
        try {
            int jumlah = Integer.parseInt(txt_jumlahBarang.getText());
            long harga_barang = Long.parseLong(txt_hargaBarang.getText());
            long subtotal = harga_barang * jumlah;
            txt_subtotalBarang.setText(String.valueOf(subtotal));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Only input numbers","Error",JOptionPane.WARNING_MESSAGE);
            txt_jumlahBarang.setText("");
            txt_hargaBarang.setText("");
        }
    }//GEN-LAST:event_txt_jumlahBarangKeyReleased

    String dataSementara[] = new String[6];
    int selectedRow = 0;
    private void tabel_sementaraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_sementaraMouseClicked
        // TODO add your handling code here:
        selectedRow = tabel_sementara.getSelectedRow();
        btn_hapusdata.setEnabled(true);
    }//GEN-LAST:event_tabel_sementaraMouseClicked

    
    private void btn_tambahbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahbarangActionPerformed
        // TODO add your handling code here:
        if (txt_jumlahBarang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Mohon diisi jumlah barang yang ingin dipesan","Please input the number",JOptionPane.WARNING_MESSAGE);
        } else {
            dataSementara[0] = txt_kodeMasuk.getText();
            dataSementara[1] = txt_kodeBarang.getText();
            dataSementara[2] = txt_namaBarang.getText();
            dataSementara[3] = txt_hargaBarang.getText();
            dataSementara[4] = txt_jumlahBarang.getText();
            dataSementara[5] = txt_subtotalBarang.getText();
            taro_barang();
            tableModel.setRowCount(0);
            settableload();
            btn_simpanbarang.setEnabled(true);
            btn_tambahbarang.setEnabled(false);
            btn_cleardata.setEnabled(false);
            clearForm();
        }
    }//GEN-LAST:event_btn_tambahbarangActionPerformed

    private void btn_cleardataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleardataActionPerformed
        // TODO add your handling code here:
        clearForm();
        btn_tambahbarang.setEnabled(false);
        btn_cleardata.setEnabled(false);
    }//GEN-LAST:event_btn_cleardataActionPerformed

    private void btn_simpanbarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanbarangActionPerformed
        // TODO add your handling code here:
         try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            int rowCount = tabel_sementara.getRowCount();
            long total = 0;
            for (int i = 0; i < rowCount; i++) {
                long subtotal = Long.parseLong(tabel_sementara.getValueAt(i, 4).toString());
                total = total + subtotal;
            }
            String SQL = "INSERT INTO `transaksi_outcome` (`ID`,`USER_ID`,`TOTAL_HARGA`,`TANGGAL`) "
                        +"VALUES ('"
                        +txt_kodeMasuk.getText()+"','"
                        +frm_utama.ID+"','"
                        +total+"','"
                        +txt_tanggalPesan.getText()+"')";
           stt.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Berhasil disimpan","Message",JOptionPane.INFORMATION_MESSAGE);
            kon.close();
            stt.close();
            Barang_Masuk();
            tableModel.setRowCount(0);
            btn_simpanbarang.setEnabled(false);
            btn_hapusdata.setEnabled(false);
            txt_kodeMasuk.setText(generateCode());
            lb_totharga.setText("0");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_simpanbarangActionPerformed

    String kode;
    private void btn_hapusdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusdataActionPerformed
        // TODO add your handling code here:
        kode = tabel_sementara.getValueAt(selectedRow, 1).toString();
        tableModel.removeRow(selectedRow);
        btn_hapusdata.setEnabled(false);
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "UPDATE `detail_transaksi` SET `STATUS` = '0' WHERE `BARANG_ID` = '"+kode+"'";
            stt.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus","Information",JOptionPane.INFORMATION_MESSAGE);
            btn_hapusdata.setEnabled(false);
            tableModel.setRowCount(0);
            settableload();
            if (tableModel.getRowCount() == 0) {
                btn_simpanbarang.setEnabled(false);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_hapusdataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_ambilBarang;
    public static rojerusan.RSMaterialButtonRectangle btn_cleardata;
    private rojerusan.RSMaterialButtonRectangle btn_hapusdata;
    private rojerusan.RSMaterialButtonRectangle btn_simpanbarang;
    public static rojerusan.RSMaterialButtonRectangle btn_tambahbarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lb_totharga;
    private javax.swing.JTable tabel_sementara;
    public static javax.swing.JTextField txt_hargaBarang;
    public static javax.swing.JTextField txt_jumlahBarang;
    public static javax.swing.JTextField txt_kodeBarang;
    private javax.swing.JTextField txt_kodeMasuk;
    public static javax.swing.JTextField txt_namaBarang;
    public static javax.swing.JTextField txt_subtotalBarang;
    private javax.swing.JTextField txt_tanggalPesan;
    // End of variables declaration//GEN-END:variables

    private void taro_barang() {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "INSERT INTO `detail_transaksi` (`TRANSAKSI_ID`,`BARANG_ID`,`HARGA`,`JUMLAH`,`SUBTOTAL`) VALUES ('"
                    +dataSementara[0]+"','"
                    +dataSementara[1]+"','"
                    +dataSementara[3]+"','"
                    +dataSementara[4]+"','"
                    +dataSementara[5]+"')";
            stt.executeUpdate(SQL);
            kon.close();
            stt.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.WARNING_MESSAGE);
        }
    }
}
