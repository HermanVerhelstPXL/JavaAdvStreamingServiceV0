package be.pxl.ja.streamingservice.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";
	private static final String ALGORITHM = "MD4";

    public static int calculateStrength(String password) {
    	int strength = 0;
    	if (password.length() > 6) {
			if (password.length() <= 10) {
				strength = 1;
			} else {
				strength = 2;
			}
			boolean hasNumber = false;
			boolean hasLowerCase = false;
			boolean hasCapitalCase = false;
			boolean hasSpecialCharacter = false;
			for (int i = 0; i < password.length(); i++) {
				if (!hasNumber && Character.isDigit(password.charAt(i))) {
					hasNumber = true;
					strength += 2;
				}
				else if (!hasLowerCase && Character.isLowerCase(password.charAt(i))){
					hasLowerCase = true;
					strength += 2;
				}
				else if (!hasCapitalCase && Character.isUpperCase(password.charAt(i))) {
					hasCapitalCase = true;
					strength += 2;
				} else if (!hasSpecialCharacter && SPECIAL_CHARACTERS.contains(String.valueOf(password.charAt(i)))) {
					hasSpecialCharacter = true;
					strength += 2;
				}
			}
		}
        return strength;
    }

	public static boolean isValid(String providedPassword, String securedPassword) {
		return securedPassword.equals(encodePassword(providedPassword));
	}

	public static String encodePassword(String password)  {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			// this is not ok!
			return null;
		}
		messageDigest.update(password.getBytes(), 0, password.length());
		return new BigInteger(1, messageDigest.digest()).toString(16);
	}
}