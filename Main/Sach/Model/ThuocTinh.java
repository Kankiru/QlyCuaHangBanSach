    package Main.Sach.Model;

    public class ThuocTinh {

        private String maSach;
        private String maTheLoai;
        private String maTacGia;
        private String maNXB;

        // Constructor, getter và setter

        public ThuocTinh(String maSach, String maTheLoai, String maTacGia, String maNXB, String maTacGia1, String tenTacGia, String maNXB1, String tenNXB) {
            this.maSach = maSach;
            this.maTheLoai = maTheLoai;
            this.maTacGia = maTacGia;
            this.maNXB = maNXB;
        }

        public ThuocTinh() {
        }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(String maTacGia) {
        this.maTacGia = maTacGia;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

   

    public Object[] toDataRow() {
        return new Object[]{maSach,maNXB,maTheLoai,maTacGia};
    }
}
