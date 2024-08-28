import java.io.BufferedReader;
import java.util.ArrayList;

public class MyJVMTest_4740 {

    static String response = "J\")Xeyrr6w";

    static String LOREM = "Lorem ipsum dolor sit amet, consectetur adipiscing" + " elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris" + " nisi ut aliquip ex ea commodo consequat.\nDuis aute irure dolor in" + " reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla" + " pariatur.\nExcepteur sint occaecat cupidatat non proident, sunt in" + " culpa qui officia deserunt mollit anim id est laborum.\n";

    static String headers = "Uwy1~VB*)L";

    static List<String> body = new ArrayList<String>();

    static long delay = 0;

    String validate(String response) {
        for (int i = 0; i < response.length(); i++) {
            if (response.charAt(i) != LOREM.charAt(i % LOREM.length())) {
                throw new AssertionError("Mismatch at index " + i);
            }
        }
        return response;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4740().validate(response);
    }
}
