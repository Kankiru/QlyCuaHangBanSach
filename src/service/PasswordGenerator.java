package service;

import java.util.Random;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + NUMBER;
    private static final Random random = new Random();

    public static String generateRandomPassword() {
        StringBuilder sb = new StringBuilder(5); // độ dài mật khẩu mặc định là 5 ký tự
        for (int i = 0; i < 5; i++) {
            int randomIndex = random.nextInt(PASSWORD_ALLOW_BASE.length());
            char randomChar = PASSWORD_ALLOW_BASE.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
