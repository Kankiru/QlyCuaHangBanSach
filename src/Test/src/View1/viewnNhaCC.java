/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan1.NhaCungCap.view;

import duan1.NhaCungCap.model.NhaCungCap;
import duan1.NhaCungCap.service.NhaCCService;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class viewnNhaCC extends javax.swing.JFrame {

    private NhaCCService NCCSV = new NhaCCService();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    public viewnNhaCC() {
        initComponents();
        fillTable(NCCSV.getAll());

        count();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        cboTimKiem2 = new javax.swing.JComboBox<>();
        txtTimKiem2 = new javax.swing.JTextField();
        btnTimKiem2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNCC = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblCount = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cboTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 51))); // NOI18N

        cboTimKiem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Email", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh", " ", " ", " " }));
        cboTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiem2ActionPerformed(evt);
            }
        });

        btnTimKiem2.setBackground(new java.awt.Color(204, 255, 204));
        btnTimKiem2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-search-50.png"))); // NOI18N
        btnTimKiem2.setText("TÌM KIẾM");
        btnTimKiem2.setBorder(null);
        btnTimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiem2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(cboTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cboTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(218, 255, 233));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(425, 425, 425))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 211, 211));

        tblNCC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NCC", "Tên NCC", "Địa Chỉ", "Email", "SDT", "Ngày Nhập", "Mô Tả"
            }
        ));
        jScrollPane1.setViewportView(tblNCC);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/NhaCungCap/view/icons8-user-50.png"))); // NOI18N
        jLabel2.setText("SỐ LƯỢNG NHÀ CUNG CẤP HIỆN CÓ:");

        lblCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 51))); // NOI18N

        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MÃ NHÀ CUNG CẤP", "TÊN NHÀ CUNG CẤP", "ĐỊA CHỈ", "EMAIL", "SỐ ĐIỆN THOẠI", "Ngày Nhập", " ", " " }));
        cboTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(204, 255, 204));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-search-50.png"))); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.setBorder(null);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(0, 917, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(203, 247, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NHÀ CUNG CẤP CHI TIẾT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(255, 0, 51))); // NOI18N

        btnThem.setBackground(new java.awt.Color(102, 255, 102));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-add-48.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setBorder(null);
        btnThem.setOpaque(true);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-delete-30.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setBorder(null);
        btnXoa.setOpaque(true);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setBackground(new java.awt.Color(0, 102, 204));
        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 255, 255));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-upward-arrow-24.png"))); // NOI18N
        btnCapNhat.setText("CẬP NHẬT");
        btnCapNhat.setBorder(null);
        btnCapNhat.setOpaque(true);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 204, 204));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-refresh-32.png"))); // NOI18N
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setBorder(null);
        btnLamMoi.setOpaque(true);
        btnLamMoi.setSelected(true);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel4.setText("Mã Nhà Cung Cấp");

        jLabel5.setText("Tên Nhà Cung Cấp");

        jLabel6.setText("Địa Chỉ");

        jLabel7.setText("Email");

        jLabel8.setText("Số Điện Thoại");

        jLabel9.setText("Mô Tả");

        jLabel10.setText("Ngày Nhập");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3))
                .addGap(80, 80, 80)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void count() {
        lblCount.setText(Integer.toString(NCCSV.count()));
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
//
//        String TENKH = txtTenKH.getText();
//        String DIACHI = txtDiaChi.getText();
//        String EMAIL = txtEmail.getText();
//        String SDT = txtSDT.getText();
//        java.util.Date NgayHienTai = new java.util.Date();
//
//        if (TENKH.isEmpty() || DIACHI.isEmpty() || EMAIL.isEmpty() || SDT.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
//            return;
//        }
//
//        if (!EMAIL.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
//            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
//            return;
//        }
//        if (!SDT.matches("(\\+84|0)\\d{9,10}")) {
//            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
//            return;
//        }
//        if (!KHSV.checkEmailExists(EMAIL).isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
//            return;
//        }
//        try {
//
//            java.util.Date utilNgSinh = txtNgSinh.getDate();
//            java.sql.Date NgSinh = new java.sql.Date(utilNgSinh.getTime());
//            String MAKH = UUID.randomUUID().toString();
//            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm khách hàng này không?");
//            if (choice == JOptionPane.YES_OPTION) {
//                if (utilNgSinh.after(NgayHienTai)) {
//                    JOptionPane.showMessageDialog(this, "Ngày tháng năm sinh bất hợp lệ");
//                    return;
//                }
//                List<KhachHang> updateList = KHSV.add(MAKH, TENKH, DIACHI, EMAIL, SDT, NgSinh);
//                if (updateList != null) {
//                    JOptionPane.showMessageDialog(this, "Thêm thành công");
//                    fillTable(KHSV.getAll());
//                    count();
//                    clear();
//                    return;
//                } else {
//                    JOptionPane.showMessageDialog(this, "Thêm thất bại ");
//                    return;
//
//                }
//            } else {
//                JOptionPane.showMessageDialog(this, "Bạn chưa thêm khách hàng nào");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Đã sảy ra lỗi khi thêm khách hàng");
//        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
//////        index = tblTTKH.getSelectedRow();
//////        if (index > -1) {
//////            List<KhachHang> updateList = KHSV.Delete(tblTTKH.getValueAt(index, 0).toString());
//////            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?");
//////            if (choice == JOptionPane.YES_OPTION) {
//////                if (updateList != null) {
//////                    JOptionPane.showMessageDialog(this, "Xóa thành công");
//////                    fillTable(KHSV.getAll());
//////                    count();
//////                    clear();
//////                    return;
//////                } else {
//////                    JOptionPane.showMessageDialog(this, "Xóa thất bại ");
//////                    return;
//////                }
//////            } else {
//////                JOptionPane.showMessageDialog(this, "Bạn chưa xóa lựa chọn nào");
//////                return;
//////            }
//////        } else {
//////            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào trên bảng");
//////            return;
//////        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
//        clear();
//        JOptionPane.showMessageDialog(this, "Đã làm mới trang nhập");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
//        String MAKH = txtMaKH.getText();
//        String TENKH = txtTenKH.getText();
//        String DIACHI = txtDiaChi.getText();
//        String EMAIL = txtEmail.getText();
//        String SDT = txtSDT.getText();
//        if (MAKH.isEmpty() || TENKH.isEmpty() || DIACHI.isEmpty() || EMAIL.isEmpty() || SDT.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
//            return;
//        }
//        if (!EMAIL.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
//            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
//            return;
//        }
//        if (index > -1) {
//            if (!SDT.matches("(\\+84|0)\\d{9,10}")) {
//                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
//                return;
//            }
//
//            try {
//
//                java.util.Date utilNgSinh = txtNgSinh.getDate();
//                java.sql.Date NgSinh = new java.sql.Date(utilNgSinh.getTime());
//                KhachHang kh = new KhachHang(MAKH, TENKH, DIACHI, EMAIL, SDT, NgSinh);
//                List<KhachHang> updateList = KHSV.Update(kh);
//                if (updateList != null) {
//                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công");
//                    fillTable(KHSV.getAll());
//                    count();
//                    clear();
//
//                } else {
//                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thất bại ");
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//                JOptionPane.showMessageDialog(this, "Đã sảy ra lỗi khi cập nhật thông tin khách hàng");
//            }
//        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void cboTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTimKiem2ActionPerformed

    private void btnTimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiem2ActionPerformed
//        if (cboTimKiem.getSelectedItem().equals("Mã Khách Hàng")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchMKH(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Tên Khách Hàng")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchTKH(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Địa Chỉ")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchDiaChi(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Email")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchEmail(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Số Điện Thoại")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchSDT(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Ngày Sinh")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchNS(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
    }//GEN-LAST:event_btnTimKiem2ActionPerformed

    private void cboTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
//        if (cboTimKiem.getSelectedItem().equals("Mã Khách Hàng")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchMKH(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Tên Khách Hàng")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchTKH(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Địa Chỉ")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchDiaChi(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Email")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchEmail(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Số Điện Thoại")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchSDT(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
//        if (cboTimKiem.getSelectedItem().equals("Ngày Sinh")) {
//            String a = txtTimKiem.getText();
//            List<KhachHang> tkh = KHSV.searchNS(a);
//            if (a.isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
//                return;
//            }
//
//            if (tkh == null || tkh.isEmpty()) {
//                model.setRowCount(0);
//                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
//                count();
//                return;
//            } else {
//                displaySearchData(tkh);
//                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
//                count();
//                return;
//            }
//        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
                if ("Nims".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewnNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewnNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewnNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewnNhaCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewnNhaCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiem2;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JComboBox<String> cboTimKiem2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lblCount;
    private javax.swing.JTable tblNCC;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTimKiem2;
    // End of variables declaration//GEN-END:variables

    private void fillTable(List<NhaCungCap> all) {
        model = (DefaultTableModel) tblNCC.getModel();
        model.setRowCount(0);
        for (NhaCungCap nhaCungCap : all) {
            model.addRow(nhaCungCap.toDataRow());
        }
    }
}
