/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main.GiamGia.model;

import java.util.Date;

/**
 *
 * @author pc
 */
public class KhuyenMai {

    private String MAKM;
    private String TENKHUYENMAI;
    private Date NGAYBATDAU;
    private Date NGAYKETTHUC;
    private int GIAMGIA;
    private String TRANGTHAI;

    public KhuyenMai(String MAKM, String TENKHUYENMAI, Date NGAYBATDAU, Date NGAYKETTHUC, int GIAMGIA, String TRANGTHAI) {
        this.MAKM = MAKM;
        this.TENKHUYENMAI = TENKHUYENMAI;
        this.NGAYBATDAU = NGAYBATDAU;
        this.NGAYKETTHUC = NGAYKETTHUC;
        this.GIAMGIA = GIAMGIA;
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

    public int getGIAMGIA() {
        return GIAMGIA;
    }

    public void setGIAMGIA(int GIAMGIA) {
        this.GIAMGIA = GIAMGIA;
    }

    public String getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(String TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }



   

   
    

    public Object[] toDataRow() {
        return new Object[]{this.MAKM, TENKHUYENMAI,  NGAYBATDAU, NGAYKETTHUC,TRANGTHAI,GIAMGIA};
    }
    
}
