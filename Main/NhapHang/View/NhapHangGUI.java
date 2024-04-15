/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Main.NhapHang.View;

import Main.NhapHang.Model.CTNhapHang;
import Main.NhapHang.Model.NhapHang;
import Main.NhapHang.Service.NhapHangService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;
import java.util.Objects;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pc
 */
public class NhapHangGUI extends javax.swing.JPanel {

    private NhapHangService NHSV = new NhapHangService();
    private DefaultTableModel model = new DefaultTableModel();

    public NhapHangGUI() {
        initComponents();
        fillTableCTNhapHang(NHSV.getAllCTPhieuNhap());
        fillTableNhapHang(NHSV.getAllPhieuNhap());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cboTK = new javax.swing.JComboBox<>();
        txtTK = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMPN = new javax.swing.JTextField();
        txtMNV = new javax.swing.JTextField();
        txtMS = new javax.swing.JTextField();
        txtMNCC = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        dcrNN = new com.toedter.calendar.JDateChooser();
        txtThanhTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPhieuNhap = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCTPhieuNhap = new javax.swing.JTable();
        btnLamMoi = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnXuatExcelPN = new javax.swing.JButton();
        btnXoaPN = new javax.swing.JButton();
        btnLammoiPN = new javax.swing.JButton();
        btnThemPN = new javax.swing.JButton();
        btnSuaPN = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaPN = new javax.swing.JTextField();
        txtMaNV = new javax.swing.JTextField();
        txtMaNCC = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        dcrNN_PhieuNhap = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        txtSoLuongPN = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 153));
        jLabel1.setText("PHIẾU NHẬP SÁCH");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(507, 507, 507))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102)), "Tìm Kiếm", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(0, 102, 0))); // NOI18N

        cboTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phiếu Nhập", "Mã Sách", "Mã Nhà Cung Cấp", "Mã Nhân Viên", " " }));

        btnTimKiem.setBackground(new java.awt.Color(225, 255, 227));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setText("TÌM KIẾM");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboTK, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jSeparator1.setBackground(new java.awt.Color(51, 51, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 51, 153));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 153));
        jLabel12.setText("CHI TIẾT PHIẾU NHẬP");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CHỨC NĂNG\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Source Sans Pro Light", 3, 24), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("MÃ NHÂN VIÊN");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("MÃ SÁCH:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("SỐ LƯỢNG");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("MÃ PHIẾU NHẬP");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("MÃ NCC:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("THÀNH TIỀN:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("GIÁ");

        txtMPN.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMPNActionPerformed(evt);
            }
        });

        txtMNV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMNVActionPerformed(evt);
            }
        });

        txtMS.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMSActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("NGÀY NHẬP:");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(28, 28, 28)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtMS, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMNV, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMPN, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMNCC)
                    .addComponent(txtSL)
                    .addComponent(txtGia)
                    .addComponent(dcrNN, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(txtThanhTien))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtMNV, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMPN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(dcrNN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8))
        );

        tblPhieuNhap.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 51), new java.awt.Color(153, 0, 0)));
        tblPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Phiếu Nhập", "Mã Nhân VIên", "Mã Nhà Cung Cấp", "Số Lượng", "Đơn Giá", "Ngày Nhập", "Tổng Tiền"
            }
        ));
        tblPhieuNhap.setSelectionBackground(new java.awt.Color(167, 255, 211));
        tblPhieuNhap.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblPhieuNhapAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPhieuNhap);

        tblCTPhieuNhap.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 255, 204)));
        tblCTPhieuNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblCTPhieuNhap.setForeground(new java.awt.Color(51, 51, 51));
        tblCTPhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ PHIẾU NHẬP", "MÃ NHÂN VIÊN", "MÃ SÁCH", "MÃ NCC", "SỐ LƯỢNG", "ĐƠN GIÁ", "NGÀY NHẬP", "TỔNG TIỀN"
            }
        ));
        tblCTPhieuNhap.setSelectionBackground(new java.awt.Color(221, 221, 255));
        tblCTPhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCTPhieuNhap);

        btnLamMoi.setBackground(new java.awt.Color(153, 153, 153));
        btnLamMoi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setText("LÀM MỚI");
        btnLamMoi.setBorder(null);
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(255, 0, 0));
        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("XÓA");
        btnXoa.setBorder(null);
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 0, 204));
        btnSua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("SỬA");
        btnSua.setBorder(null);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 153, 51));
        btnThem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.setBorder(null);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXuatExcelPN.setBackground(new java.awt.Color(0, 204, 0));
        btnXuatExcelPN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXuatExcelPN.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatExcelPN.setText("XUẤT EXCEL");
        btnXuatExcelPN.setBorder(null);
        btnXuatExcelPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelPNActionPerformed(evt);
            }
        });

        btnXoaPN.setBackground(new java.awt.Color(255, 102, 153));
        btnXoaPN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnXoaPN.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaPN.setText("XÓA");
        btnXoaPN.setBorder(null);
        btnXoaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaPNActionPerformed(evt);
            }
        });

        btnLammoiPN.setBackground(new java.awt.Color(153, 153, 153));
        btnLammoiPN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLammoiPN.setForeground(new java.awt.Color(255, 255, 255));
        btnLammoiPN.setText("LÀM MỚI");
        btnLammoiPN.setBorder(null);
        btnLammoiPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiPNActionPerformed(evt);
            }
        });

        btnThemPN.setBackground(new java.awt.Color(0, 153, 51));
        btnThemPN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnThemPN.setForeground(new java.awt.Color(255, 255, 255));
        btnThemPN.setText("THÊM");
        btnThemPN.setBorder(null);
        btnThemPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemPNActionPerformed(evt);
            }
        });

        btnSuaPN.setBackground(new java.awt.Color(102, 204, 255));
        btnSuaPN.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSuaPN.setForeground(new java.awt.Color(255, 255, 255));
        btnSuaPN.setText("SỬA");
        btnSuaPN.setBorder(null);
        btnSuaPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaPNActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "CHỨC NĂNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18), new java.awt.Color(255, 0, 0))); // NOI18N

        jLabel2.setText("MÃ PN");

        jLabel3.setText("MÃ NV");

        jLabel4.setText("MÃ NCC");

        jLabel5.setText("NGÀY NHẬP");

        jLabel6.setText("ĐƠN GIÁ");

        jLabel14.setText("SỐ LƯỢNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dcrNN_PhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(txtSoLuongPN))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuongPN, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcrNN_PhieuNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1051, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSuaPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoaPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXuatExcelPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLammoiPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(487, 487, 487))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoaPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnXuatExcelPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLammoiPN, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMPNActionPerformed

    private void txtMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMSActionPerformed

    private void txtMNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMNVActionPerformed

    private void btnXuatExcelPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelPNActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn vị trí lưu");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files (*.xlsx)", "xlsx");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave + ".xlsx");
            }

            JTable table = tblCTPhieuNhap;
            exportToExcel(table, fileToSave);
        }
    }//GEN-LAST:event_btnXuatExcelPNActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String maPN = txtMPN.getText();
        String maNV = txtMNV.getText();
        String maSach = txtMS.getText();
        String maNCC = txtMNCC.getText();
        int soLuong = Integer.parseInt(txtSL.getText());
        int donGia = Integer.parseInt(txtGia.getText());
// Kiểm tra ngày nhập
        Date ngayNhapUtil = dcrNN_PhieuNhap.getDate();
        if (ngayNhapUtil == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày nhập.");
            return;
        }

// Chuyển đổi java.util.Date sang java.sql.Date
        java.sql.Date ngayNhapSql = new java.sql.Date(ngayNhapUtil.getTime());

        int tongTien = soLuong * donGia; // Tính tổng tiền

        CTNhapHang nhapHang = new CTNhapHang(maPN, maNV, maSach, maNCC, soLuong, donGia, ngayNhapSql, tongTien);
        NHSV.themNhapHang(nhapHang);
        fillTableNhapHang(NHSV.getAllCTPhieuNhap());

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int selectedRow = tblCTPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPN = txtMPN.getText();
            String maNV = txtMNV.getText();
            String maSach = txtMS.getText();
            String maNCC = txtMNCC.getText();
            int soLuong = Integer.parseInt(txtSL.getText());
            int donGia = Integer.parseInt(txtGia.getText());
            Date ngayNhap = dcrNN.getDate();
            int tongTien = soLuong * donGia; // Tính tổng tiền

            CTNhapHang nhapHang = new CTNhapHang(maPN, maNV, maSach, maNCC, soLuong, donGia, ngayNhap, tongTien);
            NHSV.suaNhapHang(nhapHang);
            fillTableNhapHang(NHSV.getAllCTPhieuNhap());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa.");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int selectedRow = tblCTPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPN = txtMPN.getText();
            NHSV.xoaNhapHang(maPN);
            fillTableNhapHang(NHSV.getAllCTPhieuNhap());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMPN.setText("");
        txtMNV.setText("");
        txtMS.setText("");
        txtMNCC.setText("");
        txtSL.setText("");
        txtGia.setText("");
        dcrNN.setDate(null);
        txtThanhTien.setText("");
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblPhieuNhapAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblPhieuNhapAncestorAdded

    }//GEN-LAST:event_tblPhieuNhapAncestorAdded

    private void tblPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhapMouseClicked
       showDataPhieuNhap();
    }//GEN-LAST:event_tblPhieuNhapMouseClicked

    private void tblCTPhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTPhieuNhapMouseClicked
        showDataTablePhieuNhap();
    }//GEN-LAST:event_tblCTPhieuNhapMouseClicked

    private void btnXoaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaPNActionPerformed
        int selectedRow = tblPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPhieuNhap = txtMaPN.getText();

            // Thực hiện xóa phiếu nhập
            NHSV.xoaPhieuNhap(maPhieuNhap);

            // Cập nhật bảng phiếu nhập
            fillTableNhapHang(NHSV.getAllPhieuNhap());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa.");
        }
    }//GEN-LAST:event_btnXoaPNActionPerformed

    private void btnLammoiPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiPNActionPerformed
        txtMaPN.setText("");
        txtMaNV.setText("");
        txtMaNCC.setText("");
        txtDonGia.setText("");
        dcrNN_PhieuNhap.setDate(null);
    }//GEN-LAST:event_btnLammoiPNActionPerformed

    private void btnThemPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemPNActionPerformed

        {
            String maPhieuNhap = txtMaPN.getText();
            String maNhanVien = txtMaNV.getText();
            String maNhaCungCap = txtMaNCC.getText();
            int donGia = Integer.parseInt(txtDonGia.getText());
            int soLuong = Integer.parseInt(txtSoLuongPN.getText());
            Date ngayNhap = dcrNN_PhieuNhap.getDate();

            // Kiểm tra các trường bắt buộc
            if (maPhieuNhap.isEmpty() || maNhanVien.isEmpty() || maNhaCungCap.isEmpty() || txtDonGia.getText().isEmpty() || ngayNhap == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
                return;
            }

            // Tính tổng tiền
            int tongTien = soLuong * donGia;

            // Tạo đối tượng NhapHang từ thông tin nhập vào
            NhapHang phieuNhap = new NhapHang(maPhieuNhap, maNhanVien, maNhaCungCap, soLuong, donGia, ngayNhap, tongTien);

            // Thực hiện thêm phiếu nhập
            NHSV.themPhieuNhap(phieuNhap);

            // Cập nhật bảng phiếu nhập
            fillTableNhapHang(NHSV.getAllPhieuNhap());
        }
    }//GEN-LAST:event_btnThemPNActionPerformed

    private void btnSuaPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaPNActionPerformed
        int selectedRow = tblPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPhieuNhap = txtMaPN.getText();
            String maNhanVien = txtMaNV.getText();
            String maNhaCungCap = txtMaNCC.getText();
            int donGia = Integer.parseInt(txtDonGia.getText());
            int soLuong = Integer.parseInt(txtSoLuongPN.getText());
            Date ngayNhap = dcrNN_PhieuNhap.getDate();

            // Kiểm tra các trường bắt buộc
            if (maPhieuNhap.isEmpty() || maNhanVien.isEmpty() || maNhaCungCap.isEmpty() || txtDonGia.getText().isEmpty() || ngayNhap == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin.");
                return;
            }

            // Tính tổng tiền
            int tongTien = soLuong * donGia;

            // Tạo đối tượng NhapHang từ thông tin nhập vào
            NhapHang phieuNhap = new NhapHang(maPhieuNhap, maNhanVien, maNhaCungCap, soLuong, donGia, ngayNhap, tongTien);

            // Thực hiện cập nhật phiếu nhập
            NHSV.suaPhieuNhap(phieuNhap);

            // Cập nhật bảng phiếu nhập
            fillTableNhapHang(NHSV.getAllPhieuNhap());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để sửa.");
        }
    }//GEN-LAST:event_btnSuaPNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLammoiPN;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaPN;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemPN;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaPN;
    private javax.swing.JButton btnXuatExcelPN;
    private javax.swing.JComboBox<String> cboTK;
    private com.toedter.calendar.JDateChooser dcrNN;
    private com.toedter.calendar.JDateChooser dcrNN_PhieuNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblCTPhieuNhap;
    private javax.swing.JTable tblPhieuNhap;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMNCC;
    private javax.swing.JTextField txtMNV;
    private javax.swing.JTextField txtMPN;
    private javax.swing.JTextField txtMS;
    private javax.swing.JTextField txtMaNCC;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaPN;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSoLuongPN;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables

    private void fillTableCTNhapHang(List<CTNhapHang> allPhieuNhap) {
        model = (DefaultTableModel) tblCTPhieuNhap.getModel();
        model.setRowCount(0);
        for (CTNhapHang nhapHang : allPhieuNhap) {
            model.addRow(nhapHang.toDataRow());
        }
    }

    private void showDataTablePhieuNhap() {
        int selectedRow = tblCTPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPN = tblCTPhieuNhap.getValueAt(selectedRow, 0).toString();
            String maNV = tblCTPhieuNhap.getValueAt(selectedRow, 1).toString();
            String maSach = tblCTPhieuNhap.getValueAt(selectedRow, 2).toString();
            String maNCC = tblCTPhieuNhap.getValueAt(selectedRow, 3).toString();
            String soLuong = tblCTPhieuNhap.getValueAt(selectedRow, 4).toString(); // Số lượng
            String donGia = tblCTPhieuNhap.getValueAt(selectedRow, 5).toString();
            String ngayNhap = tblCTPhieuNhap.getValueAt(selectedRow, 6).toString();
            String tongTien = tblCTPhieuNhap.getValueAt(selectedRow, 7).toString();

            // Hiển thị thông tin chi tiết phiếu nhập ở các text field hoặc label tương ứng
            txtMPN.setText(maPN);
            txtMNV.setText(maNV);
            txtMS.setText(maSach);
            txtMNCC.setText(maNCC);
            txtSL.setText(soLuong);
            txtGia.setText(donGia);
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date ngayNhapDate = sdf.parse(ngayNhap);
                dcrNN.setDate(ngayNhapDate);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            txtThanhTien.setText(tongTien);
            // Hiển thị tổng tiền

        }
    }

    private void exportToExcel(JTable table, File file) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("PhieuNhap");

        DefaultTableModel model = (DefaultTableModel) table.getModel();

        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < model.getColumnCount(); col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(model.getColumnName(col));
        }

        for (int row = 0; row < model.getRowCount(); row++) {
            Row dataRow = sheet.createRow(row + 1);
            for (int col = 0; col < model.getColumnCount(); col++) {
                Object value = model.getValueAt(row, col);
                if (value instanceof Boolean) {
                    dataRow.createCell(col).setCellValue((Boolean) value);
                } else if (value instanceof Number) {
                    dataRow.createCell(col).setCellValue(((Number) value).doubleValue());
                } else {
                    dataRow.createCell(col).setCellValue(Objects.toString(value, ""));
                }
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            JOptionPane.showMessageDialog(this, "Xuất file Excel thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "File đang được mở bởi một chương trình khác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi ghi file!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void fillTableNhapHang(List<NhapHang> allPhieuNhap) {
        model = (DefaultTableModel) tblPhieuNhap.getModel();
        model.setRowCount(0);
        for (NhapHang NhapHang : allPhieuNhap) {
            model.addRow(NhapHang.toDataRow());
        }
    }

    private void showDataPhieuNhap() {
        int selectedRow = tblPhieuNhap.getSelectedRow();
        if (selectedRow >= 0) {
            String maPhieuNhap = tblPhieuNhap.getValueAt(selectedRow, 0).toString();
            String maNhanVien = tblPhieuNhap.getValueAt(selectedRow, 1).toString();
            String maNhaCungCap = tblPhieuNhap.getValueAt(selectedRow, 2).toString();
            int soLuong = Integer.parseInt(tblPhieuNhap.getValueAt(selectedRow, 3).toString());
            int donGia = Integer.parseInt(tblPhieuNhap.getValueAt(selectedRow, 4).toString());
            Date ngayNhap = (Date) tblPhieuNhap.getValueAt(selectedRow, 5);
            int tongTien = Integer.parseInt(tblPhieuNhap.getValueAt(selectedRow, 6).toString());

            // Hiển thị thông tin chi tiết phiếu nhập ở các text field hoặc label tương ứng
            txtMaPN.setText(maPhieuNhap);
            txtMaNV.setText(maNhanVien);
            txtMaNCC.setText(maNhaCungCap);
            txtSoLuongPN.setText(String.valueOf(soLuong));
            txtDonGia.setText(String.valueOf(donGia));
            dcrNN_PhieuNhap.setDate(ngayNhap);
            txtThanhTien.setText(String.valueOf(tongTien));
        }
    }

}
