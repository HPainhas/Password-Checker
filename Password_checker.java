import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Check if the password entered by the user satisfies the CSE department criteria for a valid password.
 *
 * @author Henrique Painhas
 *
 */
 
public final class PasswordChecker {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private PasswordChecker() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Enter your password: ");
        String answer = in.nextLine();

        checkPassword(answer, out);

        in.close();
        out.close();
    }

    /**
     * Checks whether the given String satisfies the CSE department criteria for
     * a valid password. Prints an appropriate message to the given output
     * stream.
     *
     * @param s
     *            the String to check
     * @param out
     *            the output stream
     */

    private static void checkPassword(String s, SimpleWriter out) {

        int counter = 0;

        if (s.length() < 6) {
            out.println("Your password MUST BE at least 6 characters long.");
        }

        if (!containsUpperCaseLetter(s)) {
            out.println("Your password DOES NOT contain an uppercase letter.");
            counter++;
        }
        if (!containsLowerCaseLetter(s)) {
            out.println("Your password DOES NOT contain an lowercase letter.");
            counter++;
        }
        if (!containsDigit(s)) {
            out.println("Your password DOES NOT contain a digit.");
            counter++;
        }
        if (!containsSpecialCharacter(s)) {
            out.println("Your password DOES NOT contain an special character.");
            counter++;
        }
        if (counter >= 3) {
            out.println("Password was REJECTED");
        }

    }

    /**
     * Checks if the given String contains an upper case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an upper case letter, false otherwise
     */

    private static boolean containsUpperCaseLetter(String s) {

        for (int i = 0; i < s.length(); i++) {
            char test = s.charAt(i);
            if (Character.isUpperCase(test)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the given String contains an lower case letter.
     *
     * @param s
     *            the String to check
     * @return true if s contains an lower case letter, false otherwise
     */

    private static boolean containsLowerCaseLetter(String s) {

        for (int i = 0; i < s.length(); i++) {
            char test = s.charAt(i);
            if (Character.isLowerCase(test)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the given String contains a digit.
     *
     * @param s
     *            the String to check
     * @return true if s contains a digit, false otherwise
     */

    private static boolean containsDigit(String s) {

        for (int i = 0; i < s.length(); i++) {
            char test = s.charAt(i);
            if (Character.isDigit(test)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the given String contains an special character.
     *
     * @param s
     *            the String to check
     * @return true if s contains an special character, false otherwise
     */

    private static boolean containsSpecialCharacter(String s) {

        String special = "!@#$%^&*()_-+={}[]:;,.?";

        for (int i = 0; i < s.length(); i++) {
            char test = s.charAt(i);

            for (int x = 0; x < special.length(); x++) {
                char test2 = special.charAt(x);

                if (test == test2) {
                    return true;
                }
            }
        }

        return false;

    }
}
