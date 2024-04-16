package Main.Sach.Model;

import java.sql.Timestamp;

public class LichSuGia {

   public String maSach;
    public Timestamp ngayCapNhat;
    public int giaBan;

    public LichSuGia() {
    }

    public LichSuGia(String maSach, Timestamp ngayCapNhat, int giaBan) {
        this.maSach = maSach;
        this.ngayCapNhat = ngayCapNhat;
        this.giaBan = giaBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public Timestamp getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Timestamp ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public Object[] toDataRow() {
        return new Object[]{this.maSach, this.ngayCapNhat, this.giaBan};
    }
}
