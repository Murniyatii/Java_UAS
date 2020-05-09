/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketkereta;
import Koneksi.dbkoneksi;
import com.mysql.jdbc.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lenovo
 */
public final class pemesanantiket extends javax.swing.JFrame {
private DefaultTableModel model;
    String tiket,nama, no, jml, hrg, bayar, id;
    
    public void getData() {
    // Mengahpus isi table siswa
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
         
        try{
        // membuat statement pemanggilan data pada table
            Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
                    String sql= "Select * from tbltransaksitiket";
                    ResultSet res = stat.executeQuery(sql);
                    
                    //penelusuran baris pada tabel
                    while(res.next()){
                    Object[] obj = new Object[8];
                    obj[0] = res.getString("No_Tiket");
                    obj[1] = res.getString("Nama_Penumpang");
                    obj[2] = res.getString("No_Kereta");
                    obj[3] = res.getString("Jumlah_Tiket");
                    obj[4] = res.getString("Harga_Tiket");
                    obj[5] = res.getString("Total_Bayar");
                    obj[6] = res.getString("ID_Petugas");
                    
                    model.addRow(obj);
                    }
        }catch(SQLException err){
            JOptionPane.showConfirmDialog(null, err.getMessage());
        }
    }
    
    public pemesanantiket() {
        initComponents();
        
        model = new DefaultTableModel();
        tbltransaksitiket.setModel(model);
        model.addColumn("No Tiket");
        model.addColumn("Nama Penumpang");
        model.addColumn("No Kereta");
        model.addColumn("Jumlah Tiket");
        model.addColumn("Harga Tiket");
        model.addColumn("Total Bayar");
        model.addColumn("ID Petugas");
        
        getData();
    }
    public void loadData(){
      tiket    = txttiket.getText();
      nama   = txtnama.getText();
      no  = txtno.getText();
      jml = txtjml.getText();
      hrg = txthrg.getText();
      bayar = txtbayar.getText();
      id = txtid.getText();
      
  }
    
    public void saveData(){
loadData();
try{
    Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
    String sql = "Insert into tbltransaksitiket (No_Tiket,Nama_Penumpang,No_Kereta,Jumlah_Tiket,Harga_Tiket,Total_Bayar,ID_Petugas)"
            + "values ('"+ tiket +"','"+ nama +"','"+ no +"','"+ jml +"','"+ hrg +"','"+ bayar +"','"+ id +"')";
    PreparedStatement p = (PreparedStatement) dbkoneksi.getKoneksi().prepareStatement(sql);
    p.executeUpdate();
    getData();
}catch(SQLException err){
    JOptionPane.showMessageDialog(null, err.getMessage());
}
}
    public void Reset(){
        tiket         ="";
        nama        ="";
        no      ="";
        jml        ="";
        hrg    ="";
        bayar        ="";
        id ="";
        txttiket.setText(tiket);
        txtnama.setText(nama);
        txtno.setText(no);
        txtjml.setText(jml);
        txthrg.setText(hrg);
        txtbayar.setText(bayar);
        txtid.setText(id);
}
    public void dataSelect(){
int i = tbltransaksitiket.getSelectedRow();
if (i == -1){
return;
}
txttiket.setText(""+model.getValueAt(i, 0));
txtnama.setText(""+model.getValueAt(i, 1));
txtno.setText(""+model.getValueAt(i, 2));
txtjml.setText(""+model.getValueAt(i, 3));
txthrg.setText(""+model.getValueAt(i, 4));
txtbayar.setText(""+model.getValueAt(i, 5));
txtid.setText(""+model.getValueAt(i, 6));

}
    public void editData(){
loadData();
try{
    Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
    String sql = "UPDATE tbltransaksitiket SET Nama_Penumpang      = '"+ nama +"',"
                                + "No_Kereta   = '"+ no +"',"
                                + "Jumlah_Tiket   = '"+ jml +"',"
                                + "Harga_Tiket   = '"+ hrg +"',"
                                + "Total_Bayar           = '"+ bayar +"',"
                                + "ID_Petugas           = '"+ id +"' WHERE No_Tiket = '"+ tiket +"'";
    PreparedStatement p = (PreparedStatement) dbkoneksi.getKoneksi().prepareStatement(sql);
    p.executeUpdate();
    getData();
    Reset();
    JOptionPane.showMessageDialog(null, "Edit berhasil....");
}catch(SQLException er){
    JOptionPane.showMessageDialog(null, er.getMessage());
}
}
    public void hapusData(){
loadData();
int pesan = JOptionPane.showConfirmDialog(null, "Anda yakin Menghapus data : "+ no +"?","Konfirmasi",
            JOptionPane.OK_CANCEL_OPTION);
if (pesan == JOptionPane.OK_OPTION){
    try{
        Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
        String sql = "DELETE FROM tbltransaksitiket WHERE No_Tiket = '"+ tiket +"'";
        PreparedStatement p = (PreparedStatement) dbkoneksi.getKoneksi().prepareStatement(sql);
        p.executeUpdate();
        getData();
        Reset();
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
    }catch(SQLException er){
        JOptionPane.showMessageDialog(null, er.getMessage());
    }
}
}
    
    /**
     * Creates new form pemesanantiket
     */
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnotiket = new javax.swing.JLabel();
        txtnamapenumpang = new javax.swing.JLabel();
        txtnokereta = new javax.swing.JLabel();
        txtjmltiket = new javax.swing.JLabel();
        txtharga = new javax.swing.JLabel();
        txttotalbayar = new javax.swing.JLabel();
        txtIDPetugas = new javax.swing.JLabel();
        txttiket = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtno = new javax.swing.JTextField();
        txtjml = new javax.swing.JTextField();
        txthrg = new javax.swing.JTextField();
        txtbayar = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltransaksitiket = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("pemesanantiket");

        jPanel1.setBackground(new java.awt.Color(255, 153, 102));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel1.setText("PEMESANAN TIKET");

        txtnotiket.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtnotiket.setText("No Tiket");

        txtnamapenumpang.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtnamapenumpang.setText("Nama Penumpang");

        txtnokereta.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtnokereta.setText("No Kereta");

        txtjmltiket.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtjmltiket.setText("Jumlah Tiket");

        txtharga.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtharga.setText("Harga Tiket");

        txttotalbayar.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txttotalbayar.setText("Total Bayar");

        txtIDPetugas.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        txtIDPetugas.setText("ID Petugas");

        txttiket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttiketActionPerformed(evt);
            }
        });

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });

        btnsave.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnedit.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnreset.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnreset.setText("RESET");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btndelete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnexit.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        tbltransaksitiket.setModel(new javax.swing.table.DefaultTableModel(
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
        tbltransaksitiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransaksitiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltransaksitiket);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(259, 259, 259)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnamapenumpang)
                            .addComponent(txtnotiket)
                            .addComponent(txtnokereta)
                            .addComponent(txtjmltiket)
                            .addComponent(txtharga)
                            .addComponent(txttotalbayar)
                            .addComponent(txtIDPetugas))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttiket, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtnama)
                            .addComponent(txtno)
                            .addComponent(txtjml)
                            .addComponent(txthrg)
                            .addComponent(txtbayar)
                            .addComponent(txtid)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnsave)
                        .addGap(18, 18, 18)
                        .addComponent(btnedit)
                        .addGap(18, 18, 18)
                        .addComponent(btnreset)
                        .addGap(18, 18, 18)
                        .addComponent(btndelete)
                        .addGap(28, 28, 28)
                        .addComponent(btnexit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnotiket)
                            .addComponent(txttiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnamapenumpang)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnokereta)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjmltiket)
                            .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga)
                            .addComponent(txthrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttotalbayar)
                            .addComponent(txtbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDPetugas)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsave)
                    .addComponent(btnedit)
                    .addComponent(btnreset)
                    .addComponent(btndelete)
                    .addComponent(btnexit))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txttiketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttiketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttiketActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        editData();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    private void tbltransaksitiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransaksitiketMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tbltransaksitiketMouseClicked

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
            java.util.logging.Logger.getLogger(pemesanantiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pemesanantiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pemesanantiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pemesanantiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pemesanantiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltransaksitiket;
    private javax.swing.JLabel txtIDPetugas;
    private javax.swing.JTextField txtbayar;
    private javax.swing.JLabel txtharga;
    private javax.swing.JTextField txthrg;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjml;
    private javax.swing.JLabel txtjmltiket;
    private javax.swing.JTextField txtnama;
    private javax.swing.JLabel txtnamapenumpang;
    private javax.swing.JTextField txtno;
    private javax.swing.JLabel txtnokereta;
    private javax.swing.JLabel txtnotiket;
    private javax.swing.JTextField txttiket;
    private javax.swing.JLabel txttotalbayar;
    // End of variables declaration//GEN-END:variables
}
