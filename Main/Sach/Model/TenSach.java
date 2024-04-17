package Main.Sach.Model;

public class TenSach {

    private String TenSach;

    public TenSach() {
    }

    public TenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public Object[] toDataRow() {
        return new Object[]{TenSach};
    }
}
