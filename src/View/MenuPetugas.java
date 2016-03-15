package View;

import Model.Barang;
import Model.Penyedia;
import Model.Petugas;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class MenuPetugas extends javax.swing.JFrame {
    
    Petugas petugas = new Petugas();
    Penyedia penyedia = new Penyedia();
    Barang brg;
    
    public MenuPetugas() {
        initComponents();
    }
    
    public MenuPetugas(Petugas petugas) {
        initComponents();
        this.petugas = petugas;
        this.lblNama.setText(this.petugas.getNama());
        this.lblId.setText(this.petugas.getId());
        this.lblNamaGudang.setText(this.petugas.getGudang().getNama_gudang());
        this.lblIdGudang.setText(String.valueOf(this.petugas.getGudang().getId()));
        this.lblKapasitasSisa.setText(String.valueOf(this.petugas.getGudang()
                .getKapasitas_Sisa()));
    }
    
    public void tampilkanCmb(){
        if(String.valueOf(cmbMenu.getSelectedItem()).equals("Tambah Barang")){
            tampilDataBarang();
            pnlHome.setVisible(false);
            pnlTambah.setVisible(true);
            pnlCari.setVisible(false);
            pnlHapus.setVisible(false);
            pnlEdit.setVisible(false);
        }else
        if(String.valueOf(cmbMenu.getSelectedItem()).equals("Home")){
            pnlHome.setVisible(true);
            pnlTambah.setVisible(false);
            pnlCari.setVisible(false);
            pnlHapus.setVisible(false);
            pnlEdit.setVisible(false);
        }else
        if(String.valueOf(cmbMenu.getSelectedItem()).equals("Cari Barang")){
            tampilDataBarangCari();
            pnlHome.setVisible(false);
            pnlTambah.setVisible(false);
            pnlCari.setVisible(true);
            pnlHapus.setVisible(false);
            pnlEdit.setVisible(false);
        }else
        if(String.valueOf(cmbMenu.getSelectedItem()).equals("Hapus Barang")){
            tampilDataBarangHapus();
            pnlHome.setVisible(false);
            pnlTambah.setVisible(false);
            pnlCari.setVisible(false);
            pnlHapus.setVisible(true);
            pnlEdit.setVisible(false);
        }else
        if(String.valueOf(cmbMenu.getSelectedItem()).equals("Edit Barang")){
            tampilDataBarangEdit();
            pnlHome.setVisible(false);
            pnlTambah.setVisible(false);
            pnlCari.setVisible(false);
            pnlHapus.setVisible(false);
            pnlEdit.setVisible(true);
        }
    }
    
    public void tampilDataBarang(){
        this.cmbDataBarang.removeAllItems();
        this.cmbDataBarang.addItem("--");
        for(int i = 0; i < this.penyedia.getIndex(); i++){
            this.cmbDataBarang.addItem(this.penyedia.
                    getDaftarBarang()[i].getNama_barang());
        }
    }
    
    public void tampilDataBarangHapus(){
        this.cmbDataBarangHapus.removeAllItems();
        this.cmbDataBarangHapus.addItem("--");
        for(int i = 0; i < this.petugas.getGudang().getIndex(); i++){
            this.cmbDataBarangHapus.addItem(this.petugas.
                getGudang().getBarangGudang()[i].getNama_barang());
        }
    }
    
    public void tampilDataBarangEdit(){
        this.cmbDataBarangEdit.removeAllItems();
        this.cmbDataBarangEdit.addItem("--");
        for(int i = 0; i < this.petugas.getGudang().getIndex(); i++){
            this.cmbDataBarangEdit.addItem(this.petugas.
                getGudang().getBarangGudang()[i].getNama_barang());
        }
    }
    
    public void tampilDataBarangCari(){
        this.cmbDataBarangCari.removeAllItems();
        this.cmbDataBarangCari.addItem("--");
        for(int i = 0; i < this.petugas.getGudang().getIndex(); i++){
            this.cmbDataBarangCari.addItem(this.petugas.
                getGudang().getBarangGudang()[i].getNama_barang());
        }
    }
    
    public void tambahBarangkeGudang(){
        if(cmbDataBarang.getSelectedItem().equals("--")){
            JOptionPane.showMessageDialog(this, "Pilih Barang yang Akan Di Tambahkan", "Error !", 0);
        }else
        if(txtJumlah.equals("")){
            JOptionPane.showMessageDialog(this, "Masukkan Jumlah Barang "
                    + "yang akan Di Tambahkan", "Error !", 0);
        }else{
            String nama_barang = String.valueOf(cmbDataBarang.getSelectedItem());
            try{
                int jumlah = Integer.parseInt(txtJumlah.getText());
                this.petugas.addBarang(nama_barang, jumlah);
                lblKapasitasSisa.setText(String.valueOf(petugas.getGudang()
                        .getKapasitas_Sisa()));
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Jumlah Barang "
                    + "salah", "Error !", 0);                
            }
        } 
    }
    
    public void hapusDataBarang(){
        if(cmbDataBarangHapus.getSelectedItem().equals("--")){
            JOptionPane.showMessageDialog(this, "Pilih Barang yang Akan Di Hapus", "Error !", 0);
        }else{
            String nama_barang = String.valueOf(cmbDataBarangHapus.getSelectedItem());
            try{
                this.petugas.hapusBarang(nama_barang);
                lblKapasitasSisa.setText(String.valueOf(petugas.getGudang()
                        .getKapasitas_Sisa()));
            }catch(Exception e){
                System.out.println(e);
                JOptionPane.showMessageDialog(this, "Jumlah Barang "
                    + "salah", "Error !", 0);                
            }
        }
    }
    
    public void editDataBarang(){
        if(cmbDataBarangEdit.getSelectedItem().equals("--")){
            JOptionPane.showMessageDialog(this, "Pilih Barang yang Akan Di Edit", "Error !", 0);
        }else
        if(txtEdit.equals("")){
            JOptionPane.showMessageDialog(this, "Masukkan Jumlah Barang "
                    + "yang Baru", "Error !", 0);
        }else{
            String nama_barang = String.valueOf(cmbDataBarangEdit.getSelectedItem());
            try{
                int jumlah = Integer.parseInt(txtEdit.getText());
                this.petugas.editBarang(nama_barang, jumlah);
                lblKapasitasSisa.setText(String.valueOf(petugas.getGudang()
                .getKapasitas_Sisa()));
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "Jumlah Barang "
                    + "salah", "Error !", 0);                
            }
        }
    }
    
    public void cariDataBarang(){
        this.petugas.lihatBarang(this,
                String.valueOf(cmbDataBarangCari.getSelectedItem()));
    }
    
    public JTable getTableDataGudang(){
        return this.tblDataGudang;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        cmbMenu = new javax.swing.JComboBox();
        pnlMenu = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        pnlTambah = new javax.swing.JPanel();
        lblNama1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbDataBarang = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnInput = new javax.swing.JButton();
        pnlCari = new javax.swing.JPanel();
        lblNama5 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cmbDataBarangCari = new javax.swing.JComboBox();
        btnCari = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDataGudang = new javax.swing.JTable();
        pnlHapus = new javax.swing.JPanel();
        lblNama3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cmbDataBarangHapus = new javax.swing.JComboBox();
        btnHapus = new javax.swing.JButton();
        pnlEdit = new javax.swing.JPanel();
        lblNama4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cmbDataBarangEdit = new javax.swing.JComboBox();
        btnEdit = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtEdit = new javax.swing.JTextField();
        lblNama2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblNamaGudang = new javax.swing.JLabel();
        lblIdGudang = new javax.swing.JLabel();
        lblKapasitasSisa = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sisdar");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Menu Petugas");

        jLabel2.setText("Nama");

        jLabel3.setText("Id");

        jLabel4.setText(":");

        jLabel5.setText(":");

        lblNama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama.setText("Nama");

        lblId.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblId.setText("Id");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        cmbMenu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Home", "Tambah Barang", "Cari Barang", "Edit Barang", "Hapus Barang" }));
        cmbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenuActionPerformed(evt);
            }
        });

        pnlMenu.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu Petugas"));
        pnlMenu.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout pnlHomeLayout = new javax.swing.GroupLayout(pnlHome);
        pnlHome.setLayout(pnlHomeLayout);
        pnlHomeLayout.setHorizontalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        pnlHomeLayout.setVerticalGroup(
            pnlHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 233, Short.MAX_VALUE)
        );

        pnlMenu.add(pnlHome, "card6");

        lblNama1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama1.setForeground(new java.awt.Color(0, 0, 204));
        lblNama1.setText("Formulir Tambah Data Barang");

        jLabel7.setText("Nama Barang");

        jLabel8.setText(":");

        jLabel9.setText("Jumlah Barang");

        jLabel10.setText(":");

        btnInput.setText("Input");
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTambahLayout = new javax.swing.GroupLayout(pnlTambah);
        pnlTambah.setLayout(pnlTambahLayout);
        pnlTambahLayout.setHorizontalGroup(
            pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTambahLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNama1)
                    .addComponent(jLabel6)
                    .addGroup(pnlTambahLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlTambahLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlah)
                            .addGroup(pnlTambahLayout.createSequentialGroup()
                                .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        pnlTambahLayout.setVerticalGroup(
            pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTambahLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbDataBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlTambahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInput)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlTambah, "card2");

        lblNama5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama5.setForeground(new java.awt.Color(0, 0, 204));
        lblNama5.setText("Formulir Cari Data Barang");

        jLabel23.setText("Nama Barang");

        jLabel24.setText(":");

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        tblDataGudang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Barang", "Id Barang", "Stok"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDataGudang);
        if (tblDataGudang.getColumnModel().getColumnCount() > 0) {
            tblDataGudang.getColumnModel().getColumn(0).setResizable(false);
            tblDataGudang.getColumnModel().getColumn(1).setResizable(false);
            tblDataGudang.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout pnlCariLayout = new javax.swing.GroupLayout(pnlCari);
        pnlCari.setLayout(pnlCariLayout);
        pnlCariLayout.setHorizontalGroup(
            pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCariLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCariLayout.createSequentialGroup()
                        .addGroup(pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNama5)
                            .addGroup(pnlCariLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlCariLayout.createSequentialGroup()
                                        .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cmbDataBarangCari, 0, 193, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))
                    .addGroup(pnlCariLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlCariLayout.setVerticalGroup(
            pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCariLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama5)
                .addGap(12, 12, 12)
                .addGroup(pnlCariLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cmbDataBarangCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCari)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlCari, "card3");

        lblNama3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama3.setForeground(new java.awt.Color(0, 0, 204));
        lblNama3.setText("Formulir Hapus Data Barang");

        jLabel17.setText("Nama Barang");

        jLabel18.setText(":");

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHapusLayout = new javax.swing.GroupLayout(pnlHapus);
        pnlHapus.setLayout(pnlHapusLayout);
        pnlHapusLayout.setHorizontalGroup(
            pnlHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHapusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama3)
                    .addGroup(pnlHapusLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDataBarangHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlHapusLayout.setVerticalGroup(
            pnlHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHapusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama3)
                .addGap(12, 12, 12)
                .addGroup(pnlHapusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbDataBarangHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus)
                .addContainerGap(147, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlHapus, "card4");

        lblNama4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama4.setForeground(new java.awt.Color(0, 0, 204));
        lblNama4.setText("Formulir Edit Data Barang");

        jLabel19.setText("Nama Barang");

        jLabel20.setText(":");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel21.setText("Jumlah Baru");

        jLabel22.setText(":");

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama4)
                    .addGroup(pnlEditLayout.createSequentialGroup()
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEditLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel22))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlEditLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(16, 16, 16)
                                .addComponent(jLabel20)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbDataBarangEdit, 0, 193, Short.MAX_VALUE)
                            .addComponent(txtEdit))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNama4)
                .addGap(12, 12, 12)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cmbDataBarangEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(txtEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnEdit)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pnlMenu.add(pnlEdit, "card5");

        lblNama2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNama2.setText("Data Gudang ");

        jLabel11.setText("Nama");

        jLabel12.setText(":");

        jLabel13.setText("Id");

        jLabel14.setText(":");

        jLabel15.setText("Kapasitas ");

        jLabel16.setText(":");

        lblNamaGudang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblNamaGudang.setText("Nama");

        lblIdGudang.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblIdGudang.setText("Id");

        lblKapasitasSisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblKapasitasSisa.setText("kap");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNama))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblId))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbMenu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNama2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKapasitasSisa)
                            .addComponent(lblIdGudang)
                            .addComponent(lblNamaGudang))))
                .addGap(18, 18, 18)
                .addComponent(pnlMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(lblNama))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(lblId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNama2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(lblNamaGudang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(lblIdGudang))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(lblKapasitasSisa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(20, 20, 20))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        LoginPetugas loginPenyedia = new LoginPetugas();
        loginPenyedia.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenuActionPerformed
        tampilkanCmb();
    }//GEN-LAST:event_cmbMenuActionPerformed

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        tambahBarangkeGudang();
        tampilDataBarang();
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        hapusDataBarang();
        tampilDataBarangHapus();
        lblKapasitasSisa.setText(String.valueOf(petugas.getGudang()
                .getKapasitas_Sisa()));
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editDataBarang();
        tampilDataBarangEdit();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        cariDataBarang();
        tampilDataBarangCari();
    }//GEN-LAST:event_btnCariActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPetugas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPetugas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnInput;
    private javax.swing.JComboBox cmbDataBarang;
    private javax.swing.JComboBox cmbDataBarangCari;
    private javax.swing.JComboBox cmbDataBarangEdit;
    private javax.swing.JComboBox cmbDataBarangHapus;
    private javax.swing.JComboBox cmbMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdGudang;
    private javax.swing.JLabel lblKapasitasSisa;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNama1;
    private javax.swing.JLabel lblNama2;
    private javax.swing.JLabel lblNama3;
    private javax.swing.JLabel lblNama4;
    private javax.swing.JLabel lblNama5;
    private javax.swing.JLabel lblNamaGudang;
    private javax.swing.JPanel pnlCari;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlHapus;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlTambah;
    private javax.swing.JTable tblDataGudang;
    private javax.swing.JTextField txtEdit;
    private javax.swing.JTextField txtJumlah;
    // End of variables declaration//GEN-END:variables
}
