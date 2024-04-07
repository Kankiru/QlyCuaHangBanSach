 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien_Model;
import service.NhanVien_Service;

/**
 *
 * @author Admin
 */
public class NhanVien_View extends javax.swing.JPanel {

    private NhanVien_Service service = new NhanVien_Service();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int index = -1;

    public NhanVien_View() {
        initComponents();
        this.fillTable(service.finAll());
        this.fillTable2(service.fillAll2());
    }

    // hiển thị lên bảng nhân viên
    void fillTable(List<NhanVien_Model> list1) {
        dtm = (DefaultTableModel) tbl_NhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVien_Model nv : list1) {
            dtm.addRow(nv.getDataRow());
        }

    }
// bảng tài khoản

    void fillTable2(List<NhanVien_Model> list2) {
        dtm = (DefaultTableModel) tbl_TaiKhoan.getModel();
        dtm.setRowCount(0);
        for (NhanVien_Model tk : list2) {
            dtm.addRow(tk.getDataRow2());
        }
    }

// show data lên form
    void showData(int index) {

        txt_Ma.setText(tbl_NhanVien.getValueAt(index, 0).toString());
        if (tbl_NhanVien.getValueAt(index, 1) != null) {
            txt_Ten.setText(tbl_NhanVien.getValueAt(index, 1).toString());
        } else {
            txt_Ten.setText("");
        }
        if (tbl_NhanVien.getValueAt(index, 2) != null) {
            txt_Email.setText(tbl_NhanVien.getValueAt(index, 2).toString());
        } else {
            txt_Email.setText("");
        }
        if (tbl_NhanVien.getValueAt(index, 3) != null) {
            txt_SoDienThoai.setText(tbl_NhanVien.getValueAt(index, 3).toString());
        } else {
            txt_SoDienThoai.setText("");
        }
        if (tbl_NhanVien.getValueAt(index, 4) != null) {
            String gioiTinh = tbl_NhanVien.getValueAt(index, 4).toString();
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdb_Nam.setSelected(true);
            } else {
                rdb_Nu.setSelected(true);
            }
        } else {
            buttonGroup1.clearSelection();
        }
        if (tbl_NhanVien.getValueAt(index, 5) != null) {
            DC_NgaySinh.setDate((Date) tbl_NhanVien.getValueAt(index, 5));
        } else {
            DC_NgaySinh.setDate(null);
        }
    }

    // show data ở bảng tài khoản
    void showData2(int index) {
        txt_Ma1.setText(tbl_TaiKhoan.getValueAt(index, 0).toString());
        if (tbl_TaiKhoan.getValueAt(index, 1) != null) {
            txt_TenDangNhap.setText(tbl_TaiKhoan.getValueAt(index, 1).toString());
            txt_NoiDung.setText("Tài khoản:" + tbl_TaiKhoan.getValueAt(index, 1).toString() + "\nMật khẩu::");
        } else {
            txt_TenDangNhap.setText("");
            txt_NoiDung.setText("Tài khoản:" + "\nMật Khẩu:");
        }
        if (tbl_TaiKhoan.getValueAt(index, 2) != null) {
            txt_MatKhau.setText(tbl_TaiKhoan.getValueAt(index, 2).toString());
            txt_MatKhau2.setText(tbl_TaiKhoan.getValueAt(index, 2).toString());
        } else {
            txt_MatKhau.setText("");
            txt_MatKhau2.setText("");
            return;
        }
        if (tbl_TaiKhoan.getValueAt(index, 3) != null) {
            txt_EmailTo.setText(tbl_TaiKhoan.getValueAt(index, 3).toString());
        } else {
            txt_EmailTo.setText("");
        }
        if (tbl_TaiKhoan.getValueAt(index, 4) != null) {
            String role = tbl_TaiKhoan.getValueAt(index, 4).toString();
            // Đặt giá trị được chọn trong combobox
            cbo_Quyen.setSelectedItem(role);
        } else {
            cbo_Quyen.setSelectedIndex(-1); // Chọn không có mục nào nếu giá trị null
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

    // đọc dữ liệu từ form tk
    NhanVien_Model ReadForm2() {
        String ten, matKhau, ma, matKhau2, email, roles;
        ma = txt_Ma1.getText().trim();
        ten = txt_TenDangNhap.getText().trim();
        matKhau = txt_MatKhau.getText().trim();
        matKhau2 = txt_MatKhau2.getText().trim();
        email = txt_EmailTo.getText();
        roles = cbo_Quyen.getSelectedItem().toString();
        NhanVien_Model tk = new NhanVien_Model(ma, email, ten, matKhau, roles);
        return tk;
    }
// validate

    boolean checkData2() {
        if (txt_TenDangNhap.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Tên đăng nhập");
            return false;
        }
        if (txt_MatKhau.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không được để trống Mật khẩu");
            return false;
        } else if (!txt_MatKhau.getText().equals(txt_MatKhau2.getText())) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không giống nhau");
            return false;
        }
        if (cbo_Quyen.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa phân quyền tài khoản");
            return false;
        }

        return true;

    }

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
            String emailPattern = "^[a-zA-Z0-9._%+-]+@(gmail.com|fpt.edu.vn)$";
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

    void clearForm2() {
        txt_Ma.setText("");
        txt_MatKhau.setText("");
        txt_TenDangNhap.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
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
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btn_Tim = new javax.swing.JButton();
        cbx_TimKiem = new javax.swing.JComboBox<>();
        txt_TimKiem = new javax.swing.JTextField();
        btn_Tim1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_TaiKhoan = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Ma1 = new javax.swing.JTextField();
        txt_TenDangNhap = new javax.swing.JTextField();
        btn_CapNhatTaiKhoan = new javax.swing.JButton();
        btn_XoaTaiKhoan = new javax.swing.JButton();
        txt_MatKhau = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        txt_MatKhau2 = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        cbo_Quyen = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_FromEmail = new javax.swing.JTextField();
        txt_FromPassWord = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txt_EmailTo = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txt_Subject = new javax.swing.JTextField();
        txt_NoiDung = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 234, Short.MAX_VALUE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bảng Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1001, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản Lý Nhân Viên");
        jLabel1.setOpaque(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nhập Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

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

        txt_Ma.setBackground(new java.awt.Color(242, 242, 242));

        txt_Ten.setBackground(new java.awt.Color(242, 242, 242));

        buttonGroup1.add(rdb_Nam);
        rdb_Nam.setSelected(true);
        rdb_Nam.setText("Nam");

        buttonGroup1.add(rdb_Nu);
        rdb_Nu.setText("Nữ");

        txt_Email.setBackground(new java.awt.Color(242, 242, 242));
        txt_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmailActionPerformed(evt);
            }
        });

        txt_SoDienThoai.setBackground(new java.awt.Color(242, 242, 242));
        txt_SoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SoDienThoaiActionPerformed(evt);
            }
        });

        DC_NgaySinh.setBackground(new java.awt.Color(255, 255, 0));
        DC_NgaySinh.setDateFormatString("yyyy-MM-dd");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DC_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb_Nam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(105, 105, 105))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_SoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdb_Nam)
                    .addComponent(rdb_Nu)
                    .addComponent(btn_Sua))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DC_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(19, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Xoa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));

        btn_Tim.setBackground(new java.awt.Color(255, 255, 0));
        btn_Tim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_Tim.setText("Tìm Kiếm");
        btn_Tim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimActionPerformed(evt);
            }
        });

        cbx_TimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Họ Tên", " " }));

        btn_Tim1.setBackground(new java.awt.Color(255, 255, 0));
        btn_Tim1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_Tim1.setText("Hiển Thị Toàn Bộ Nhân Viên");
        btn_Tim1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tim1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(cbx_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Tim)
                .addGap(36, 36, 36)
                .addComponent(btn_Tim1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_TimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btn_Tim, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addComponent(btn_Tim1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addComponent(cbx_TimKiem))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("Quản Lý Nhân Viên", jPanel2);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" TÀI KHOẢN");

        tbl_TaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Nhân Viên", "Tên Đăng Nhập", "Mật Khẩu", "Email", "Quyền"
            }
        ));
        tbl_TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_TaiKhoan);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Thiết Lập Thông Tin Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã Nhân Viên:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Tên Đăng Nhập:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Quyền:");

        txt_Ma1.setEditable(false);
        txt_Ma1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Ma1ActionPerformed(evt);
            }
        });

        txt_TenDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_TenDangNhapActionPerformed(evt);
            }
        });

        btn_CapNhatTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_CapNhatTaiKhoan.setText("Cập Nhật");
        btn_CapNhatTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CapNhatTaiKhoanActionPerformed(evt);
            }
        });

        btn_XoaTaiKhoan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_XoaTaiKhoan.setText("Xóa");
        btn_XoaTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaTaiKhoanActionPerformed(evt);
            }
        });

        txt_MatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MatKhauMouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Mật Khẩu:");

        txt_MatKhau2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_MatKhau2MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Nhập Lại Mật Khẩu:");

        cbo_Quyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Admin" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_Ma1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                            .addComponent(txt_TenDangNhap)
                            .addComponent(txt_MatKhau)
                            .addComponent(txt_MatKhau2)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(cbo_Quyen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_CapNhatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_XoaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Ma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MatKhau2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_Quyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_CapNhatTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_XoaTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Gửi Thông Tin Tài Khoản Cho Nhân Viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "From", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Mật khẩu:");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel14.setText("Email:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_FromEmail)
                    .addComponent(txt_FromPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_FromEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txt_FromPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "To", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("Subject:");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setText("Email To:");

        txt_EmailTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_EmailToActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Nội dung:");

        txt_Subject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SubjectActionPerformed(evt);
            }
        });

        txt_NoiDung.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txt_NoiDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NoiDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_EmailTo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txt_NoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txt_EmailTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_Subject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_NoiDung))
                .addGap(16, 16, 16))
        );

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Gửi");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản Lý Tài Khoản", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimActionPerformed
        if (cbx_TimKiem.getSelectedItem().equals("Mã")) {
            String a = txt_TimKiem.getText();
            List<NhanVien_Model> nv = service.searchIDNV(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập gì để tìm kiếm");
                return;
            }
            if (nv == null || nv.isEmpty()) {
                dtm.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);
                return;
            } else {
                fillTable(nv);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");
                return;
            }
        }
        if (cbx_TimKiem.getSelectedItem().equals("Họ Tên")) {
            String a = txt_TimKiem.getText();
            List<NhanVien_Model> tnv = service.searchTen(a);
            if (a.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Bạn chưa nhập gì để tìm kiếm");
                return;
            }

            if (tnv == null || tnv.isEmpty()) {
                dtm.setRowCount(0);
                JOptionPane.showMessageDialog(this, "Không có bất kí kết quả nào với " + a);

                return;
            } else {
                fillTable(tnv);
                JOptionPane.showMessageDialog(this, "Đã tìm thấy");

                return;
            }
        }
    }//GEN-LAST:event_btn_TimActionPerformed

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
                    this.fillTable2(service.fillAll2());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void txt_SoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SoDienThoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SoDienThoaiActionPerformed

    private void txt_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmailActionPerformed

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        index = tbl_NhanVien.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void tbl_TaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TaiKhoanMouseClicked
        index = tbl_TaiKhoan.getSelectedRow();
        this.showData2(index);
    }//GEN-LAST:event_tbl_TaiKhoanMouseClicked

    private void txt_Ma1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Ma1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Ma1ActionPerformed

    private void btn_CapNhatTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CapNhatTaiKhoanActionPerformed
        index = tbl_TaiKhoan.getSelectedRow();
        String ID;
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để cập nhật");
        } else {
            ID = tbl_TaiKhoan.getValueAt(index, 0).toString();
            if (this.checkData2()) {
                if (service.Update(ID, this.ReadForm2()) > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                    this.fillTable2(service.fillAll2());
                } else {
                    JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_CapNhatTaiKhoanActionPerformed

    private void btn_XoaTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaTaiKhoanActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không", "Hỏi", JOptionPane.YES_NO_CANCEL_OPTION, 1);

        index = tbl_TaiKhoan.getSelectedRow();
        String ID;
        if (check == JOptionPane.YES_OPTION) {
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng để xóa");
            } else {
                ID = tbl_TaiKhoan.getValueAt(index, 0).toString();
                if (service.Delete(ID) > 0) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    this.fillTable2(service.fillAll2());
                    this.clearForm2();
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_XoaTaiKhoanActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        int check = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không", "Hỏi", JOptionPane.YES_NO_CANCEL_OPTION, 1);
        if (this.checkData()) {
            if (check == JOptionPane.YES_OPTION) {
                if (service.addNhanVien(this.ReadForm()) > 0) {
                    JOptionPane.showMessageDialog(this, " Thêm Thành công");
                    this.fillTable(service.finAll());
                    this.fillTable2(service.fillAll2());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại");
                }
            }
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_Tim1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tim1ActionPerformed
        List<NhanVien_Model> ListNV = service.finAll();
        if (ListNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Danh sách nhân viên hiện tại đang trống");
        } else {
            fillTable(service.finAll());
            JOptionPane.showMessageDialog(this, "Đã hiển thị thông tin tất cả nhân viên");
        }
    }//GEN-LAST:event_btn_Tim1ActionPerformed

    private void txt_MatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MatKhauMouseClicked
        txt_MatKhau.setText("");

    }//GEN-LAST:event_txt_MatKhauMouseClicked

    private void txt_MatKhau2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_MatKhau2MouseClicked
        txt_MatKhau2.setText("");
    }//GEN-LAST:event_txt_MatKhau2MouseClicked

    private void txt_EmailToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_EmailToActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_EmailToActionPerformed

    private void txt_SubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SubjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SubjectActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", 587);

            String accountName = txt_FromEmail.getText();
            String accountPassword = txt_FromPassWord.getText();

            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(accountName, accountPassword);
                }
            });

            String from = txt_FromEmail.getText();
            String to = txt_EmailTo.getText();
            String subject = txt_Subject.getText();
            String body = txt_NoiDung.getText();

            Message msg = new MimeMessage(s);

            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);
            msg.setText(body);

            Transport.send(msg);

            JOptionPane.showMessageDialog(null, "Gửi Email thành công", "Message",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
        } catch (MessagingException ex) {
            ex.printStackTrace();
            //         Logger.getLogger(SendMail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_NoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NoiDungActionPerformed

    }//GEN-LAST:event_txt_NoiDungActionPerformed

    private void txt_TenDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_TenDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_TenDangNhapActionPerformed

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVien_View().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DC_NgaySinh;
    private javax.swing.JButton btn_CapNhatTaiKhoan;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Tim;
    private javax.swing.JButton btn_Tim1;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_XoaTaiKhoan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_Quyen;
    private javax.swing.JComboBox<String> cbx_TimKiem;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdb_Nam;
    private javax.swing.JRadioButton rdb_Nu;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTable tbl_TaiKhoan;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_EmailTo;
    private javax.swing.JTextField txt_FromEmail;
    private javax.swing.JPasswordField txt_FromPassWord;
    private javax.swing.JTextField txt_Ma;
    private javax.swing.JTextField txt_Ma1;
    private javax.swing.JPasswordField txt_MatKhau;
    private javax.swing.JPasswordField txt_MatKhau2;
    private javax.swing.JTextField txt_NoiDung;
    private javax.swing.JTextField txt_SoDienThoai;
    private javax.swing.JTextField txt_Subject;
    private javax.swing.JTextField txt_Ten;
    private javax.swing.JTextField txt_TenDangNhap;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables

}
