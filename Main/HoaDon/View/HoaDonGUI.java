package Main.HoaDon.View;

import Main.HoaDon.Model.HoaDon;
import Main.HoaDon.Service.HoaDonService;
import Main.NhanVien.NhanVien.service.NhanVien_Service;
import Main.QLKH.QlyCuaHangBanSach.Servicce.KhachHangService;
import Main.Sach.Service.SachService;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HoaDonGUI extends javax.swing.JPanel {

    SachService SSV = new SachService();
    KhachHangService KHSV = new KhachHangService();
    private HoaDonService HDSV = new HoaDonService();
    private NhanVien_Service NVSV = new NhanVien_Service();
    private DefaultTableModel model = new DefaultTableModel();
    private int index = -1;

    public HoaDonGUI() {
        initComponents();
        fillTableHoaDon(HDSV.getAllHoaDon());
        cbxMaNV.setModel(new DefaultComboBoxModel<>(NVSV.getAllMaNhanVien().toArray(new String[0])));
        cbxMaKH.setModel(new DefaultComboBoxModel<>(KHSV.getMaKHList().toArray(new String[0])));
        cbxMaSach.setModel(new DefaultComboBoxModel<>(SSV.getMaSachList().toArray(new String[0])));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btCTHDF = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChiTietHD = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        txSoLuongHD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txTongTienHD = new javax.swing.JTextField();
        btXuat = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        btFHD = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btSua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtTk = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txDau = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txCuoi = new javax.swing.JTextField();
        btTim = new javax.swing.JButton();
        cbxChoiceTK = new javax.swing.JComboBox<>();
        btXoa = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        cbxMaNV = new javax.swing.JComboBox<>();
        cbxMaKH = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbxMaSach = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã KH", "Mã NV", "Mã Sách", "Số Lượng", "Ngày Lập"
            }
        ));
        tblHoaDon.setSelectionBackground(new java.awt.Color(234, 234, 252));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(204, 0, 204))); // NOI18N

        btCTHDF.setBackground(new java.awt.Color(153, 153, 153));
        btCTHDF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCTHDF.setForeground(new java.awt.Color(255, 255, 255));
        btCTHDF.setText("HIỂN THỊ TẤT CẢ");
        btCTHDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btCTHDF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCTHDFMouseClicked(evt);
            }
        });

        tblChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã HĐ", "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Tổng Tiền", "Voucher", "Thành tiền"
            }
        ));
        tblChiTietHD.setSelectionBackground(new java.awt.Color(0, 204, 0));
        jScrollPane2.setViewportView(tblChiTietHD);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Số lượng hóa đơn:");
        jLabel12.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel12.setMinimumSize(new java.awt.Dimension(62, 15));

        txSoLuongHD.setEditable(false);
        txSoLuongHD.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Tổng tiền các hóa đơn:");
        jLabel17.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel17.setMinimumSize(new java.awt.Dimension(62, 15));

        txTongTienHD.setEditable(false);
        txTongTienHD.setBackground(new java.awt.Color(255, 255, 255));

        btXuat.setBackground(new java.awt.Color(0, 0, 204));
        btXuat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btXuat.setForeground(new java.awt.Color(255, 255, 255));
        btXuat.setText("XUẤT EXCEL");
        btXuat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXuatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btCTHDF, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(btXuat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addComponent(btXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btCTHDF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txSoLuongHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Số Lượng");

        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btFHD.setBackground(new java.awt.Color(0, 153, 0));
        btFHD.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btFHD.setForeground(new java.awt.Color(255, 255, 255));
        btFHD.setText("LÀM MỚI");
        btFHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btFHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btFHDMouseClicked(evt);
            }
        });
        btFHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFHDActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mã KH:");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("QUẢN LÝ HÓA ĐƠN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mã NV:");

        btSua.setBackground(new java.awt.Color(255, 153, 0));
        btSua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btSua.setText("SỬA");
        btSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "TÌM KIẾM HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Chọn phương thức tìm kiếm");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Giá tiền từ:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("đến");

        btTim.setBackground(new java.awt.Color(153, 255, 153));
        btTim.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btTim.setForeground(new java.awt.Color(51, 0, 51));
        btTim.setText("TÌM KIẾM");
        btTim.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btTimMouseClicked(evt);
            }
        });
        btTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimActionPerformed(evt);
            }
        });

        cbxChoiceTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Hóa Đơn", "Mã Nhân Viên", "Mã Khách Hàng", "Mã Sách" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxChoiceTK, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTk, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(256, 256, 256)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxChoiceTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btTim, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        btXoa.setBackground(new java.awt.Color(255, 0, 0));
        btXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btXoa.setForeground(new java.awt.Color(255, 255, 255));
        btXoa.setText("XÓA");
        btXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Mã HĐ:");
        jLabel2.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel2.setMinimumSize(new java.awt.Dimension(62, 15));

        txtMaHD.setEditable(false);
        txtMaHD.setBackground(new java.awt.Color(255, 255, 255));

        cbxMaNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mã Sách");
        jLabel3.setMaximumSize(new java.awt.Dimension(62, 15));
        jLabel3.setMinimumSize(new java.awt.Dimension(62, 15));

        cbxMaSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThem.setBackground(new java.awt.Color(51, 204, 0));
        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("THÊM");
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(37, 37, 37)
                        .addComponent(cbxMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btFHD, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(495, 495, 495)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbxMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btFHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)))
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("HÓA ĐƠN", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        showDataHoaDon();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btCTHDFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCTHDFMouseClicked

    }//GEN-LAST:event_btCTHDFMouseClicked

    private void btFHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btFHDMouseClicked

    }//GEN-LAST:event_btFHDMouseClicked

    private void btXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXuatMouseClicked

    }//GEN-LAST:event_btXuatMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked

    }//GEN-LAST:event_btSuaMouseClicked

    private void btTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTimMouseClicked

    }//GEN-LAST:event_btTimMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked

    }//GEN-LAST:event_btXoaMouseClicked

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        int selectedRow = tblHoaDon.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy mã hóa đơn từ hàng được chọn
        String maHD = tblHoaDon.getValueAt(selectedRow, 0).toString();

        // Gọi phương thức xóa hóa đơn từ HoaDonService
        HDSV.deleteHoaDon(maHD);

        // Làm mới bảng và các trường nhập liệu
        refreshData();
    }//GEN-LAST:event_btXoaActionPerformed

    private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThemMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        String maNV = cbxMaNV.getSelectedItem().toString();
        String maKH = cbxMaKH.getSelectedItem().toString();
        String maSach = cbxMaSach.getSelectedItem().toString();
        int soLuong = Integer.parseInt(txtSoLuong.getText());

        // Lấy đơn giá từ sách
        // Gọi phương thức thêm hóa đơn từ HoaDonService
        HDSV.addHoaDon(maKH, maNV, maSach, soLuong);
        // Làm mới bảng và các trường nhập liệu
        refreshData();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        int selectedRow = tblHoaDon.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để sửa.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy mã hóa đơn từ hàng được chọn trong bảng
        String maHD = txtMaHD.getText();

        // Lấy dữ liệu từ các trường nhập liệu
        String maKH = cbxMaKH.getSelectedItem().toString();
        String maNV = cbxMaNV.getSelectedItem().toString();
        String maSach = cbxMaSach.getSelectedItem().toString();
        String soLuongText = txtSoLuong.getText();

        // Kiểm tra xem tất cả các trường đã được nhập vào không
        if (maKH.isEmpty() || maNV.isEmpty() || maSach.isEmpty() || soLuongText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra xem người dùng đã nhập vào một số nguyên hợp lệ hay không
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongText);
        } catch (NumberFormatException e) {
            // Nếu không phải là số nguyên hợp lệ, hiển thị thông báo lỗi và thoát khỏi phương thức
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Tạo một đối tượng HoaDon mới với dữ liệu từ các trường nhập liệu
        HoaDon hoaDon = new HoaDon(maHD, maKH, maNV, maSach, soLuong /*Các trường khác*/);

        // Gọi phương thức cập nhật trong HoaDonService để cập nhật dữ liệu
        boolean result = HDSV.updateHoaDon(hoaDon);

        // Kiểm tra xem cập nhật thành công hay không
        if (result) {
            // Nếu cập nhật thành công, cập nhật lại dữ liệu trong bảng
            fillTableHoaDon(HDSV.getAllHoaDon());
            JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thành công.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật hóa đơn thất bại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSuaActionPerformed

    private void btFHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFHDActionPerformed
        refreshData();
        fillTableHoaDon(HDSV.getAllHoaDon());
    }//GEN-LAST:event_btFHDActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void btTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimActionPerformed
        String selectedOption = cbxChoiceTK.getSelectedItem().toString();
        String keyword = txtTk.getText().trim();

        switch (selectedOption) {
            case "Mã Hóa Đơn":
                List<HoaDon> hoaDonList = HDSV.timHoaDonTheoMaHD(keyword);
                if (hoaDonList != null && !hoaDonList.isEmpty()) {
                    fillTableHoaDon(hoaDonList);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với mã này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    model.setRowCount(0);
                }
                break;
            case "Mã Nhân Viên":
                hoaDonList = HDSV.timHoaDonTheoMaNV(keyword);
                if (hoaDonList != null && !hoaDonList.isEmpty()) {
                    fillTableHoaDon(hoaDonList);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với mã này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    model.setRowCount(0);
                }
                break;
            case "Mã Khách Hàng":
                hoaDonList = HDSV.timHoaDonTheoMaKH(keyword);
                if (hoaDonList != null && !hoaDonList.isEmpty()) {
                    fillTableHoaDon(hoaDonList);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với mã này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    model.setRowCount(0);
                }
                break;
            case "Mã Sách":
                hoaDonList = HDSV.timHoaDonTheoMaMS(keyword);
                if (hoaDonList != null && !hoaDonList.isEmpty()) {
                    fillTableHoaDon(hoaDonList);
                } else {
                    JOptionPane.showMessageDialog(this, "Không tìm thấy hóa đơn với mã này.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    model.setRowCount(0);
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event_btTimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCTHDF;
    private javax.swing.JButton btFHD;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btTim;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btXuat;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbxChoiceTK;
    private javax.swing.JComboBox<String> cbxMaKH;
    private javax.swing.JComboBox<String> cbxMaNV;
    private javax.swing.JComboBox<String> cbxMaSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblChiTietHD;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txCuoi;
    private javax.swing.JTextField txDau;
    private javax.swing.JTextField txSoLuongHD;
    private javax.swing.JTextField txTongTienHD;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTk;
    // End of variables declaration//GEN-END:variables

    private void fillTableHoaDon(List<HoaDon> allHoaDon) {
        model = (DefaultTableModel) tblHoaDon.getModel();
        model.setRowCount(0);
        for (HoaDon hoaDon : allHoaDon) {
            model.addRow(hoaDon.toDataRow());
        }
    }

    private void showDataHoaDon() {
        int selectedRow = tblHoaDon.getSelectedRow();

        // Kiểm tra xem có hàng nào được chọn không
        if (selectedRow != -1) {
            // Lấy thông tin từ hàng được chọn
            String maHD = tblHoaDon.getValueAt(selectedRow, 0).toString();
            String maKH = tblHoaDon.getValueAt(selectedRow, 1).toString();
            String maNV = tblHoaDon.getValueAt(selectedRow, 2).toString();
            String maSach = tblHoaDon.getValueAt(selectedRow, 3).toString();
            int soLuong = Integer.parseInt(tblHoaDon.getValueAt(selectedRow, 4).toString());

            // Điền thông tin vào các thành phần trên giao diện người dùng
            txtMaHD.setText(maHD);
            // Điền thông tin vào các JComboBox nếu cần
            cbxMaKH.setSelectedItem(maKH);
            cbxMaNV.setSelectedItem(maNV);
            cbxMaSach.setSelectedItem(maSach);
            txtSoLuong.setText(Integer.toString(soLuong));
        }
    }

    private void refreshData() {
        fillTableHoaDon(HDSV.getAllHoaDon());
        txtMaHD.setText("");
        txtSoLuong.setText("");

    }

}
