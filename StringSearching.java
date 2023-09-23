import java.util.Scanner;

public class StringSearching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(", ");

            if (parts.length != 2) {
                System.out.println("false");
                continue;
            }

            String text = parts[0];
            String pattern = parts[1];

            boolean isMatch = isSubstring(text, pattern);
            System.out.println(isMatch ? "true" : "false");
        }

        scanner.close();
    }

    public static boolean isSubstring(String text, String pattern) {
        int textLen = text.length();
        int patternLen = pattern.length();
        int i = 0;
        int j = 0;

        while (i < textLen && j < patternLen) {
            if (pattern.charAt(j) == '\\') {
                // Check for an escaped asterisk
                if (j + 1 < patternLen && pattern.charAt(j + 1) == '*') {
                    if (i < textLen) {
                        j += 2;
                        continue;
                    }
                }
            }

            if (pattern.charAt(j) == '*') {
                // Match zero or more characters
                while (j < patternLen && pattern.charAt(j) == '*') {
                    j++;
                }

                if (j == patternLen) {
                    return true; // Asterisk at the end matches the rest of the text
                }

                while (i < textLen && text.charAt(i) != pattern.charAt(j)) {
                    i++;
                }
            } else if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        return j == patternLen;
    }
}
