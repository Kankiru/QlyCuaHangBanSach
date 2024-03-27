/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.GiamGia.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class KhuyenMai {

    private String MAKM;
    private String TENKHUYENMAI;
    private String LOAIKHUYENMAI;
    private Date NGAYBATDAU;
    private Date NGAYKETTHUC;
    private String TRANGTHAI;

    public KhuyenMai(String MAKM, String TENKHUYENMAI, String LOAIKHUYENMAI, Date NGAYBATDAU, Date NGAYKETTHUC, String TRANGTHAI) {
        this.MAKM = MAKM;
        this.TENKHUYENMAI = TENKHUYENMAI;
        this.LOAIKHUYENMAI = LOAIKHUYENMAI;
        this.NGAYBATDAU = NGAYBATDAU;
        this.NGAYKETTHUC = NGAYKETTHUC;
        this.TRANGTHAI = TRANGTHAI;
    }

    public KhuyenMai() {
    }

    public String getMAKM() {
        return MAKM;
    }

    public void setMAKM(String MAKM) {
        this.MAKM = MAKM;
    }

   

   

    public String getTENKHUYENMAI() {
        return TENKHUYENMAI;
    }

    public void setTENKHUYENMAI(String TENKHUYENMAI) {
        this.TENKHUYENMAI = TENKHUYENMAI;
    }

    public String getLOAIKHUYENMAI() {
        return LOAIKHUYENMAI;
    }

    public void setLOAIKHUYENMAI(String LOAIKHUYENMAI) {
        this.LOAIKHUYENMAI = LOAIKHUYENMAI;
    }

    public Date getNGAYBATDAU() {
        return NGAYBATDAU;
    }

    public void setNGAYBATDAU(Date NGAYBATDAU) {
        this.NGAYBATDAU = NGAYBATDAU;
    }

    public Date getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(Date NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }


   

   
    

    public Object[] toDataRow() {
        return new Object[]{this.MAKM, TENKHUYENMAI, LOAIKHUYENMAI, NGAYBATDAU, NGAYKETTHUC,TRANGTHAI};
    }
    
}
