import java.util.*;
import java.io.*;

public class MyJVMTest_5019 {

    static InputStream is = null;

    static String type = "|J,919?A(z";

    static List<String> expected = new ArrayList<String>();

    static String waitForMessage = "s*Ac4(&rG|";

    boolean allExpectedMessagesWereFound() {
        return expected.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5019().allExpectedMessagesWereFound());
    }
}
