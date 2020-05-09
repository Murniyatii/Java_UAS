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
public final class datatiket extends javax.swing.JFrame {
    private DefaultTableModel model;
    String no, kursi, nama, tgl, jam, harga, id;
    
    public void getData() {
    // Mengahpus isi table 
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
         
        try{
        // membuat statement pemanggilan data pada table
            Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
                    String sql= "Select * from tbltiket";
                    ResultSet res = stat.executeQuery(sql);
                    
                    //penelusuran baris pada tabel
                    while(res.next()){
                    Object[] obj = new Object[7];
                    obj[0] = res.getString("No_Kereta");
                    obj[1] = res.getString("No_Kursi");
                    obj[2] = res.getString("Nama_Penumpang");
                    obj[3] = res.getString("Tgl_Keberangkatan");
                    obj[4] = res.getString("Jam_keberangkatan");
                    obj[5] = res.getString("Harga_Tiket");
                    obj[6] = res.getString("ID_Petugas");
                    
                    model.addRow(obj);
                    }
        }catch(SQLException err){
            JOptionPane.showConfirmDialog(null, err.getMessage());
        }
    }

    /**
     * Creates new form datatiket
     */
    public datatiket() {
        initComponents();
        
        model = new DefaultTableModel();
        tbltiket.setModel(model);
        model.addColumn("No Kereta");
        model.addColumn("No Kursi");
        model.addColumn("Nama Penumpang");
        model.addColumn("Tgl Keberangkatan");
        model.addColumn("Jam Keberangkatan");
        model.addColumn("Harga Tiket");
        model.addColumn("ID Petugas");
        
        
        getData();
    }
    
public void loadData(){
      no   = txtno.getText();
      kursi  = txtkursi.getText();
      nama = txtnama.getText();
      tgl = txttgl.getText();
      jam =  txtjam.getText();
      harga = txtharga.getText();
      id = txtid.getText();
      
  }

public void saveData(){
loadData();
try{
    Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
    String sql = "Insert into tbltiket (No_Kereta, No_Kursi, Nama_Penumpang, Tgl_Keberangkatan, Jam_Keberangkatan, Harga_Tiket, ID_Petugas)"
            + "values ('"+ no +"','"+ kursi +"','"+ nama +"','"+ tgl +"','"+ jam +"','"+ harga +"','"+ id +"')";
    PreparedStatement p = (PreparedStatement) dbkoneksi.getKoneksi().prepareStatement(sql);
    p.executeUpdate();
    getData();
}catch(SQLException err){
    JOptionPane.showMessageDialog(null, err.getMessage());
}
}
public void Reset(){
        no         ="";
        kursi        ="";
        nama      ="";
        tgl        ="";
        jam    ="";
        harga        ="";
        id ="";
        txtno.setText(no);
        txtkursi.setText(kursi);
        txtnama.setText(nama);
        txttgl.setText(tgl);
        txtjam.setText(jam);
        txtharga.setText(harga);
        txtid.setText(id);
}

public void dataSelect(){
int i = tbltiket.getSelectedRow();
if (i == -1){
return;
}
txtno.setText(""+model.getValueAt(i, 0));
txtkursi.setText(""+model.getValueAt(i, 1));
txtnama.setText(""+model.getValueAt(i, 2));
txttgl.setText(""+model.getValueAt(i, 3));
txtjam.setText(""+model.getValueAt(i, 4));
txtharga.setText(""+model.getValueAt(i, 5));
txtid.setText(""+model.getValueAt(i, 6));

}

public void editData(){
loadData();
try{
    Statement stat = (Statement) dbkoneksi.getKoneksi().createStatement();
    String sql = "UPDATE tbltiket SET No_Kursi      = '"+ kursi +"',"
                                + "Nama_Penumpang   = '"+ nama +"',"
                                + "Tgl_Keberangkatan   = '"+ tgl +"',"
                                + "Jam_Keberangkatan   = '"+ jam +"',"
                                + "Harga_Tiket           = '"+ harga +"',"
                                + "ID_Petugas           = '"+ id +"' WHERE No_Kereta = '"+ no +"'";
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
        String sql = "DELETE FROM tbltiket WHERE No_Kereta = '"+ no +"'";
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
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        datatiket = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtno = new javax.swing.JTextField();
        txtkursi = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        txtjam = new javax.swing.JTextField();
        txtharga = new javax.swing.JTextField();
        txtid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbltiket = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txttgl = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        datatiket.setBackground(new java.awt.Color(255, 204, 153));

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 18)); // NOI18N
        jLabel1.setText("DATA TIKET");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setText("No Kereta");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setText("No Kursi");

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel4.setText("Nama Penumpang");

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel6.setText("Jam Keberangkatan");

        jLabel7.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel7.setText("Harga Tiket");

        jLabel8.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel8.setText("ID Petugas");

        txtno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoActionPerformed(evt);
            }
        });

        txtjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjamActionPerformed(evt);
            }
        });

        txtharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthargaActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 204, 204));

        tbltiket.setModel(new javax.swing.table.DefaultTableModel(
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
        tbltiket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltiketMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbltiket);

        btnSave.setBackground(new java.awt.Color(255, 102, 102));
        btnSave.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(255, 51, 0));
        btnEdit.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 51, 51));
        btnReset.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(102, 255, 102));
        btndelete.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 102, 51));
        btnexit.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 12)); // NOI18N
        btnexit.setText("EXIT");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel5.setText("Tgl Keberangkatan");

        javax.swing.GroupLayout datatiketLayout = new javax.swing.GroupLayout(datatiket);
        datatiket.setLayout(datatiketLayout);
        datatiketLayout.setHorizontalGroup(
            datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datatiketLayout.createSequentialGroup()
                .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(datatiketLayout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(datatiketLayout.createSequentialGroup()
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datatiketLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(datatiketLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addComponent(btnSave)))
                        .addGap(23, 23, 23)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(datatiketLayout.createSequentialGroup()
                                .addComponent(btnEdit)
                                .addGap(42, 42, 42)
                                .addComponent(btnReset)
                                .addGap(34, 34, 34)
                                .addComponent(btndelete)
                                .addGap(32, 32, 32)
                                .addComponent(btnexit))
                            .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(datatiketLayout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtno, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                .addComponent(txtkursi)
                                .addComponent(txtnama)
                                .addComponent(txtharga))
                            .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        datatiketLayout.setVerticalGroup(
            datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(datatiketLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(datatiketLayout.createSequentialGroup()
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtkursi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(datatiketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnReset)
                    .addComponent(btnEdit)
                    .addComponent(btndelete)
                    .addComponent(btnexit))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(datatiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(datatiket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txthargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthargaActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        editData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void txtnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        Reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        saveData();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        hapusData();
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnexitActionPerformed

    private void tbltiketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltiketMouseClicked
        // TODO add your handling code here:
        dataSelect();
    }//GEN-LAST:event_tbltiketMouseClicked

    private void txtjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjamActionPerformed

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
            java.util.logging.Logger.getLogger(datatiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datatiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datatiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datatiket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datatiket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JPanel datatiket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbltiket;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtjam;
    private javax.swing.JTextField txtkursi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtno;
    private javax.swing.JTextField txttgl;
    // End of variables declaration//GEN-END:variables
}
