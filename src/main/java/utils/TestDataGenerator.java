package utils;

import java.util.Locale;
import java.util.Random;

public class TestDataGenerator {
    Random random = new Random();
    String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    String ALPHANUMERICS = "abcdefghijklmnopqrstuvwxyz1234567890";
    String NUMERICS = "0123456789";
    String SPECIAL_CHARACTERS = "&%#$";

    public String getRandomStringOfGivenLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
        }
        return sb.toString();
    }

    public String getRandomAlphanumericStringOfGivenLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHANUMERICS.charAt(random.nextInt(ALPHABETS.length())));
        }
        return sb.toString();
    }


    public String getRandomValidEmail() {
        return getRandomStringOfGivenLength(2) + "." + getRandomAlphanumericStringOfGivenLength(5) + "@test.com";
    }

    public String getRandomPassword() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; ++i) {
            sb.append(ALPHANUMERICS.toUpperCase(Locale.ROOT).charAt(random.nextInt(ALPHABETS.length())));
        }
        for (int i = 0; i < 2; ++i) {
            sb.append(ALPHANUMERICS.charAt(random.nextInt(ALPHABETS.length())));
        }
        for (int i = 0; i < 2; ++i) {
            sb.append(NUMERICS.charAt(random.nextInt(NUMERICS.length())));
        }
        for (int i = 0; i < 2; ++i) {
            sb.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));
        }
        return sb.toString();
    }
}
