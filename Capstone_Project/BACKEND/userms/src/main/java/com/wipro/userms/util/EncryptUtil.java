package com.wipro.userms.util;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptUtil {
    public static String getEncryptedPassword(String plainPassword, String salt) {
        if (salt == null) {
            salt = BCrypt.gensalt();
            System.out.println("Salt Generated=" + salt);
        }
        return BCrypt.hashpw(plainPassword, salt);
    }
}
