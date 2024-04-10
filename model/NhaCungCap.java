/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duan1.NhaCungCap.model;



/**
 *
 * @author pc
 */
public class NhaCungCap {

    private String MANCC;
    private String TENNHACUNGCAP;
    private String DIACHI;
    private String EMAIL;
    private String SDT;
 
    private String MOTA;

    public NhaCungCap() {
    }

    public NhaCungCap(String MANCC, String TENNHACUNGCAP, String DIACHI, String EMAIL, String SDT, String MOTA) {
        this.MANCC = MANCC;
        this.TENNHACUNGCAP = TENNHACUNGCAP;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.SDT = SDT;
       
        this.MOTA = MOTA;
    }

    public String getMANCC() {
        return MANCC;
    }

    public void setMANCC(String MANCC) {
        this.MANCC = MANCC;
    }

    public String getTENNHACUNGCAP() {
        return TENNHACUNGCAP;
    }

    public void setTENNHACUNGCAP(String TENNHACUNGCAP) {
        this.TENNHACUNGCAP = TENNHACUNGCAP;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

 

    public String getMOTA() {
        return MOTA;
    }

    public void setMOTA(String MOTA) {
        this.MOTA = MOTA;
    }

    public Object[] toDataRow() {
        return new Object[]{this.MANCC, TENNHACUNGCAP, DIACHI, EMAIL, SDT, MOTA};
    }

}
