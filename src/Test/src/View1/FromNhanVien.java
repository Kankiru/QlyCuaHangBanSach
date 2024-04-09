/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View1;
import Model1.NhanVien_Model;

import Service1.NhanVien_Service;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author admin
 */
public class FromNhanVien extends javax.swing.JPanel {
 private NhanVien_Service service = new NhanVien_Service();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int index = -1;
    /**
     * Creates new form FromNhanVien
     */
    public FromNhanVien() {
      initComponents();
        
        this.fillTable(service.finAll());
    }
// hiển thị lên bảng

    void fillTable(List<NhanVien_Model> list) {
        dtm = (DefaultTableModel) tbl_NhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVien_Model nv : list) {
            dtm.addRow(nv.getDataRow());
        }
    }

// show data lên form
    void showData(int index) {
        String gioiTinh;
        if (tbl_NhanVien.getValueAt(index, 0) != null) {
            txt_Ma.setText(tbl_NhanVien.getValueAt(index, 0).toString());
        }
        if (tbl_NhanVien.getValueAt(index, 1) != null) {
            txt_Ten.setText(tbl_NhanVien.getValueAt(index, 1).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; // Dừng việc hiển thị thông tin nếu giá trị là null
        }
        if (tbl_NhanVien.getValueAt(index, 2) != null) {
            txt_Email.setText(tbl_NhanVien.getValueAt(index, 2).toString());
        }
        if (tbl_NhanVien.getValueAt(index, 3) != null) {
            txt_SoDienThoai.setText(tbl_NhanVien.getValueAt(index, 3).toString());
        }
        if (tbl_NhanVien.getValueAt(index, 4) != null) {
            gioiTinh = tbl_NhanVien.getValueAt(index, 4).toString();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdb_Nam.setSelected(true);
            } else {
                rdb_Nu.setSelected(true);
            }
        }
        if (tbl_NhanVien.getValueAt(index, 5) != null) {
            DC_NgaySinh.setDate((Date) tbl_NhanVien.getValueAt(index, 5));
        }
    }
// đọc dữ liệu từ form

    NhanVien_Model ReadForm() {
        String ma, ten, email, soDienThoai, gioiTinh;
        Date ngaySinh;
        ma = txt_Ma.getText().trim();
        ten = txt_Ten.getText().trim();
        email = txt_Email.getText().trim();
        soDienThoai = txt_SoDienThoai.getText().trim();
        if (rdb_Nam.isSelected()) {
            gioiTinh = "Nam";
        } else {
            gioiTinh = "Nữ";
        }
        ngaySinh = DC_NgaySinh.getDate();
        NhanVien_Model nv = new NhanVien_Model(ma, ten, email, soDienThoai, gioiTinh, ngaySinh);
        return nv;
    }
// validate

    boolean checkData() {
        if (txt_Ma.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mã");
            return false;
        }
        if (txt_Ten.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Tên");
            return false;
        }

        // Kiểm tra dữ liệu số điện thoại
        String soDienThoai = txt_SoDienThoai.getText();
        if (soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Số điện thoại");
            return false;
        } else {
            // Kiểm tra độ dài và số đầu tiên
            int doDaiSoDienThoai = soDienThoai.length();
            if (doDaiSoDienThoai < 9 || doDaiSoDienThoai > 12 || !soDienThoai.startsWith("0")) {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
                return false;
            }
        }
        // Kiểm tra email
        if (txt_Email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Email");
            return false;
        } else {
            String emailPattern = "[a-zA-Z0-9._%+-]+@gmail.com";
            String email = txt_Email.getText().trim();
            boolean isValidEmail = Pattern.matches(emailPattern, email);
            if (!isValidEmail) {
                JOptionPane.showMessageDialog(this, "Email không đúng định dạng");
                return false;
            }
        }
        // Kiểm tra dữ liệu ngày sinh
        Date ngaySinh = DC_NgaySinh.getDate();
        if (ngaySinh == null) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng yyyy-MM-dd hoặc để trống");
            return false;
        }

        return true;

    }
// clearForm

    void clearForm() {
        txt_Ma.setText("");
        txt_Email.setText("");
        txt_SoDienThoai.setText("");
        txt_Ten.setText("");
        DC_NgaySinh.setDate(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_TimTheoTen = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_Ma = new javax.swing.JTextField();
        txt_Ten = new javax.swing.JTextField();
        rdb_Nam = new javax.swing.JRadioButton();
        rdb_Nu = new javax.swing.JRadioButton();
        txt_Email = new javax.swing.JTextField();
        txt_SoDienThoai = new javax.swing.JTextField();
        DC_NgaySinh = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 204, 204));

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");
        jLabel1.setOpaque(true);

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Họ Và Tên", "Email", "Số Điện Thoại", "Giới Tính", "Ngày Sinh"
            }
        ));
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        jPanel2.setBackground(new java.awt.Color(51, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        btn_Them.setBackground(new java.awt.Color(255, 255, 0));
        btn_Them.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setBackground(new java.awt.Color(255, 255, 0));
        btn_Sua.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Sua.setText("Cập Nhật");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_Xoa.setBackground(new java.awt.Color(255, 255, 0));
        btn_Xoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_TimTheoTen.setBackground(new java.awt.Color(255, 255, 0));
        btn_TimTheoTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_TimTheoTen.setText("Tìm Theo Tên");
        btn_TimTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimTheoTenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106)
                .addComponent(btn_TimTheoTen)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them)
                    .addComponent(btn_Sua)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_TimTheoTen))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nhập Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Giới Tính:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Họ Và Tên:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Mã Nhân Viên:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Số Điện Thoại:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ngày Sinh:");

        txt_Ma.setBackground(new java.awt.Color(255, 255, 51));

        txt_Ten.setBackground(new java.awt.Color(255, 255, 0));

        rdb_Nam.setBackground(new java.awt.Color(0, 255, 255));
        buttonGroup1.add(rdb_Nam);
        rdb_Nam.setSelected(true);
        rdb_Nam.setText("Nam");

        buttonGroup1.add(rdb_Nu);
        rdb_Nu.setText("Nữ");

        txt_Email.setBackground(new java.awt.Color(255, 255, 0));
        txt_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmailActionPerformed(evt);
            }
        });

        txt_SoDienThoai.setBackground(new java.awt.Color(255, 255, 0));
        txt_SoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoDienThoaiActionPerformed(evt);
            }
        });

        DC_NgaySinh.setBackground(new java.awt.Color(255, 255, 0));
        DC_NgaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DC_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdb_Nam)
                    .addComponent(rdb_Nu))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DC_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        index = tbl_NhanVien.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không", "Hỏi", JOptionPane.YES_NO_CANCEL_OPTION, 1);
        if (this.checkData()) {
            if (check == JOptionPane.YES_OPTION) {
                if (service.addNhanVien(this.ReadForm()) > 0) {
                    JOptionPane.showMessageDialog(this, " Thêm Thành công");
                    this.fillTable(service.finAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        index = tbl_NhanVien.getSelectedRow();
        String ma;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để sửa");
        } else {
            ma = tbl_NhanVien.getValueAt(index, 0).toString();
            if (this.checkData()) {
                if (service.UpdateNhanVien(ma, this.ReadForm()) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.fillTable(service.finAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không", "Hỏi", JOptionPane.YES_NO_CANCEL_OPTION, 1);

        index = tbl_NhanVien.getSelectedRow();
        String ma;
        if (check == JOptionPane.YES_OPTION) {
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
            } else {
                ma = tbl_NhanVien.getValueAt(index, 0).toString();
                if (service.DeleteNhanVien(ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    this.fillTable(service.finAll());
                    this.clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_TimTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimTheoTenActionPerformed
        String ten = JOptionPane.showInputDialog("Mời nhập tên nhân viên cần tìm");

        if (ten == null) {
            // Người dùng nhấn cancel, không có tên được nhập
            JOptionPane.showMessageDialog(this, "Bạn chọn thoát");
            return;
        }

        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên nhân viên cần tìm");
        } else if (service.FindByTen(ten).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên!");
            return;
        }
        this.fillTable(service.FindByTen(ten));

    }//GEN-LAST:event_btn_TimTheoTenActionPerformed

    private void txt_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmailActionPerformed

    private void txt_SoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoDienThoaiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DC_NgaySinh;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimTheoTen;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_Nam;
    private javax.swing.JRadioButton rdb_Nu;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_Ten;
    // End of variables declaration//GEN-END:variables
}
