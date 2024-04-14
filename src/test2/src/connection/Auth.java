//package connection;
//
//import DAO.TaiKhoanDAO;
//import DTO.TaiKhoan;
//
//public class Auth {
//
//    public static TaiKhoan user = null;
//
//    public static void clear() {
//        Auth.user = null;
//    }
//
//    public static boolean isLogin() {
//        return Auth.user != null;
//    }
//
//    public static boolean isManager() {
//        return Auth.isLogin() && user.getQuyen().equals("Quản lý");
//    }
//
//    public static boolean isTechnician() {
//        return Auth.isLogin() && user.getQuyen().equals("Kỹ thuật");
//    }
//
//    public static void login(String username, String password) {
//        TaiKhoan loggedInUser = TaiKhoanDAO.checkLogin(username, password);
//        if (loggedInUser != null) {
//            Auth.user = loggedInUser;
//        }
//    }
//}
