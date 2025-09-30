import java.util.Scanner;

public class Authentication {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final String USER_USERNAME = "user";
    private static final String USER_PASSWORD = "user123";

    public static String authenticate(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
            return "admin";
        } else if (username.equals(USER_USERNAME) && password.equals(USER_PASSWORD)) {
            return "user";
        } else {
            return null; // Invalid
        }
    }
}
