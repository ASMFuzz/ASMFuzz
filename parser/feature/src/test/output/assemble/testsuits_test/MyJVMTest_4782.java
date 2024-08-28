import java.util.*;

public class MyJVMTest_4782 {

    static String value = "Nz1nw%*7$G";

    long parseHex(String value) {
        long result = 0;
        if (value.length() < 2 || value.charAt(0) != '0' || value.charAt(1) != 'x') {
            return -1L;
        }
        for (int i = 2; i < value.length(); i++) {
            result *= 16;
            char ch = value.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result += (ch - '0');
            } else if (ch >= 'a' && ch <= 'f') {
                result += (ch - 'a') + 10;
            } else if (ch >= 'A' && ch <= 'F') {
                result += (ch - 'A') + 10;
            } else {
                throw new NumberFormatException("" + ch + " is not a valid hex digit");
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4782().parseHex(value));
    }
}
