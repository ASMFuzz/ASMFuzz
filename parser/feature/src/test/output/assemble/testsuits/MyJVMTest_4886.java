import java.util.*;

public class MyJVMTest_4886 {

    static String str = "&m2L[kxzt+";

    String escapeToUnicode(String str) {
        StringBuilder b = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c < 128) {
                b.append(c);
            } else {
                b.append("\\u").append(String.format("%04X", (int) c));
            }
        }
        return b.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4886().escapeToUnicode(str));
    }
}
