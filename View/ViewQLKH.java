/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package duan1.QuanLyKhachHang.View;

import duan1.QuanLyKhachHang.Model.KhachHang;
import duan1.QuanLyKhachHang.Servicce.KhachHangService;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.util.Locale;

import java.util.UUID;

/**
 *
 * @author pc
 */
public class ViewQLKH extends javax.swing.JFrame {

    private KhachHangService KHSV = new KhachHangService();
    private DefaultTableModel model;
    private int index = -1;

    public ViewQLKH() {
        initComponents();
        txtSLKH.setEnabled(false);
        txtMaKH.setEditable(false);
        fillTable(KHSV.getAll());
        txtSLKH.setText(Integer.toString(KHSV.count()));
    }

    private void count() {
        txtSLKH.setText(Integer.toString(KHSV.count()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField7 = new javax.swing.JTextField();
        pnlTTKH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTTKH = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txtSLKH = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cboTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        txtNgSinh = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btExxcel = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTextField7.setText("jTextField7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlTTKH.setBackground(new java.awt.Color(255, 255, 204));
        pnlTTKH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblTTKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Email", "Số Điện Thoại", "Ngày sinh"
            }
        ));
        tblTTKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTTKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTTKH);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/icons8-user-50.png"))); // NOI18N
        jLabel10.setText("Số Lượng khách hàng: ");

        txtSLKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlTTKHLayout = new javax.swing.GroupLayout(pnlTTKH);
        pnlTTKH.setLayout(pnlTTKHLayout);
        pnlTTKHLayout.setHorizontalGroup(
            pnlTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTTKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 952, Short.MAX_VALUE)
                    .addGroup(pnlTTKHLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSLKH, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlTTKHLayout.setVerticalGroup(
            pnlTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTTKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTTKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSLKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Mã Khách Hàng");

        jLabel4.setText("Địa Chỉ");

        jLabel5.setText("Họ Tên");

        jLabel6.setText("Số Điện Thoại");

        jLabel7.setText("Email");

        jLabel8.setText("Ngày sinh");

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(204, 0, 51))); // NOI18N

        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Khách Hàng", "Tên Khách Hàng", "Email", "Địa Chỉ", "Số Điện Thoại", "Ngày Sinh", " ", " ", " " }));
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        txtNgSinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNgSinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(36, 36, 36)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(351, 351, 351))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(352, 352, 352))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHẬP THÔNG TIN");
        jLabel1.setOpaque(true);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("THÔNG TIN KHÁCH HÀNG");

        btExxcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btExxcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/excel.png"))); // NOI18N
        btExxcel.setText("Xuất Excel");
        btExxcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExxcelActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/duan1/QuanLyKhachHang/View/list.png"))); // NOI18N
        jButton1.setText("HIỂN THỊ DANH SÁCH KHÁCH HÀNG");
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlTTKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
            .addGroup(layout.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(1054, Short.MAX_VALUE)
                    .addComponent(btExxcel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTTKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(91, 91, 91)
                    .addComponent(btExxcel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(797, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btExxcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExxcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExxcelActionPerformed

    private void txtSLKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLKHActionPerformed

    }//GEN-LAST:event_txtSLKHActionPerformed

    private void tblTTKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTTKHMouseClicked
        index = tblTTKH.getSelectedRow();
        if (index >= -1) {
            txtMaKH.setText(tblTTKH.getValueAt(index, 0).toString());
            txtTenKH.setText(tblTTKH.getValueAt(index, 1).toString());
            txtDiaChi.setText(tblTTKH.getValueAt(index, 2).toString());
            txtEmail.setText(tblTTKH.getValueAt(index, 3).toString());
            txtSDT.setText(tblTTKH.getValueAt(index, 4).toString());
            String dateStr = tblTTKH.getValueAt(index, 5).toString();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                java.util.Date ns = dateFormat.parse(dateStr);
                txtNgSinh.setDate(ns);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tblTTKHMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clear();
        JOptionPane.showMessageDialog(this, "Đã làm mới trang nhập");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String TENKH = txtTenKH.getText();
        String DIACHI = txtDiaChi.getText();
        String EMAIL = txtEmail.getText();
        String SDT = txtSDT.getText();

        if (TENKH.isEmpty() || DIACHI.isEmpty() || EMAIL.isEmpty() || SDT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
            return;
        }
        if (!EMAIL.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            return;
        }
        if (!SDT.matches("\\d{10,11}")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
            return;
        }
        if (!KHSV.checkEmailExists(EMAIL).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
            return;
        }
        try {

            java.util.Date utilNgSinh = txtNgSinh.getDate();
            java.sql.Date NgSinh = new java.sql.Date(utilNgSinh.getTime());
            String MAKH = UUID.randomUUID().toString();
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm khách hàng này không?");
            if (choice == JOptionPane.YES_OPTION) {
                List<KhachHang> updateList = KHSV.add(MAKH, TENKH, DIACHI, EMAIL, SDT, NgSinh);
                if (updateList != null) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công");
                    fillTable(KHSV.getAll());
                    count();
                    clear();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại ");
                    return;

                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa thêm khách hàng nào");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        index = tblTTKH.getSelectedRow();
        if (index > -1) {
            List<KhachHang> updateList = KHSV.Delete(tblTTKH.getValueAt(index, 0).toString());
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa không?");
            if (choice == JOptionPane.YES_OPTION) {
                if (updateList != null) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    fillTable(KHSV.getAll());
                    clear();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại ");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn chưa xóa lựa chọn nào");
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào trên bảng");
            return;
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cboTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTimKiemActionPerformed

    private void txtNgSinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNgSinhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgSinhMouseClicked

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        String MAKH = txtMaKH.getText();
        String TENKH = txtTenKH.getText();
        String DIACHI = txtDiaChi.getText();
        String EMAIL = txtEmail.getText();
        String SDT = txtSDT.getText();
        if (!EMAIL.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            JOptionPane.showMessageDialog(this, "Email không hợp lệ.");
            return;
        }
        if (index > -1) {
            if (!SDT.matches("\\d{10,11}")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ.");
                return;
            }

            try {

                java.util.Date utilNgSinh = txtNgSinh.getDate();
                java.sql.Date NgSinh = new java.sql.Date(utilNgSinh.getTime());
                KhachHang kh = new KhachHang(MAKH, TENKH, DIACHI, EMAIL, SDT, NgSinh);
                List<KhachHang> updateList = KHSV.Update(kh);
                if (updateList != null) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thành công");
                    fillTable(KHSV.getAll());
                    count();
                    clear();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thông tin thất bại ");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (cboTimKiem.getSelectedItem().equals("Mã Khách Hàng")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchMKH(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cboTimKiem.getSelectedItem().equals("Tên Khách Hàng")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchTKH(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cboTimKiem.getSelectedItem().equals("Địa Chỉ")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchDiaChi(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cboTimKiem.getSelectedItem().equals("Email")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchEmail(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cboTimKiem.getSelectedItem().equals("Số Điện Thoại")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchSDT(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cboTimKiem.getSelectedItem().equals("Ngày Sinh")) {
            String a = txtTimKiem.getText();
            List<KhachHang> tkh = KHSV.searchNS(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạnn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tkh == null || tkh.isEmpty()) {
                model.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                displaySearchData(tkh);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillTable(KHSV.getAll());
        JOptionPane.showMessageDialog(this, "Đã hiển thị thông tin tất cả khách hàng");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewQLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewQLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewQLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewQLKH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewQLKH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExxcel;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JPanel pnlTTKH;
    private javax.swing.JTable tblTTKH;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private com.toedter.calendar.JDateChooser txtNgSinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSLKH;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void fillTable(List<KhachHang> all) {
        model = (DefaultTableModel) tblTTKH.getModel();
        model.setRowCount(0);
        for (KhachHang khachHang : all) {
            model.addRow(khachHang.toDataRow());
        }
    }

    private void clear() {
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtNgSinh.setDate(null);

    }

    private void displaySearchData(List<KhachHang> tkh) {
        model = (DefaultTableModel) tblTTKH.getModel();
        model.setRowCount(0);
        for (KhachHang khachHang : tkh) {
            model.addRow(new Object[]{khachHang.getMAKH(), khachHang.getTENKH(), khachHang.getDIACHI(), khachHang.getEMAIL(), khachHang.getSDT(), khachHang.getNgaySinh()});
        }
    }
}
