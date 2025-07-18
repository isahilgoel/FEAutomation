package utils;

import java.util.Locale;
import java.util.Random;

public class TestDataGenerator {
    Random random = new Random();
    String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
    String ALPHANUMERICS = "abcdefghijklmnopqrstuvwxyz1234567890";
    String NUMERICS = "0123456789";
    String SPECIAL_CHARACTERS = "&%#$";

    /**
     * Generates a random string of given length using lowercase alphabets.
     *
     * @param length Length of the random string to be generated.
     * @return A random string of the specified length.
     */
    public String getRandomStringOfGivenLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHABETS.charAt(random.nextInt(ALPHABETS.length())));
        }
        return sb.toString();
    }

    /**
     * Generates a random alphanumeric string of given length.
     *
     * @param length Length of the random alphanumeric string to be generated.
     * @return A random alphanumeric string of the specified length.
     */
    public String getRandomAlphanumericStringOfGivenLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(ALPHANUMERICS.charAt(random.nextInt(ALPHABETS.length())));
        }
        return sb.toString();
    }

    /**
     * Generates a random valid email address.
     * The email format is: <random_string>.<random_alphanumeric>@test.com
     *
     * @return A random valid email address.
     */
    public String getRandomValidEmail() {
        return getRandomStringOfGivenLength(2) + "." + getRandomAlphanumericStringOfGivenLength(5) + "@test.com";
    }

    /**
     * Generates a random password containing:
     * - 2 uppercase letters
     * - 2 lowercase letters
     * - 2 digits
     * - 2 special characters
     *
     * @return A random password.
     */
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
