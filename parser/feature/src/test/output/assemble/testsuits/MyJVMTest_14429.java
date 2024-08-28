import java.util.*;
import java.io.*;

public class MyJVMTest_14429 {

    static InputStream is = null;

    static String type = "*^I0iCO%l/";

    static List<String> expected = new ArrayList<String>();

    static String waitForMessage = "!h^^fsHaIG";

    boolean allExpectedMessagesWereFound() {
        return expected.isEmpty();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14429().allExpectedMessagesWereFound());
    }
}
