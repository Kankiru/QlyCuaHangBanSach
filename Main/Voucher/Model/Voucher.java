package Main.Voucher.Model;



public class Voucher {
    private String maVoucher;
    private int dieuKien;
    private String tenVoucher;
    private int giamGia;


 
    public Voucher(String maVoucher, String tenVoucher, int dieuKien, int giamGia) {
        this.maVoucher = maVoucher;
        this.dieuKien = dieuKien;
        this.tenVoucher = tenVoucher;
        this.giamGia = giamGia;
   
    }

    public Voucher() {
    }

    // Getters and setters
    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public int getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(int dieuKien) {
        this.dieuKien = dieuKien;
    }

    public String getTenVoucher() {
        return tenVoucher;
    }

    public void setTenVoucher(String tenVoucher) {
        this.tenVoucher = tenVoucher;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

   

    // Các thuộc tính và phương thức khác

    public Object[] toDataRow() {
        return new Object[]{maVoucher, tenVoucher, dieuKien, giamGia};
    }


}
