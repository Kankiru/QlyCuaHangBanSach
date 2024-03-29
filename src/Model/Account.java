/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author admin
 */
public class Account {
    private String fullName;
    private String taiKhoan;
    private String pass;

    public Account() {
    }

    public Account(String fullName, String taiKhoan, String pass) {
        this.fullName = fullName;
        this.taiKhoan = taiKhoan;
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Account{" + "fullName=" + fullName + ", taiKhoan=" + taiKhoan + ", pass=" + pass + '}';
    }
    public Object[] toDataRow(){
       return new Object[]{
       this.fullName,
        this.taiKhoan,
        this.pass
       };
    }
}
