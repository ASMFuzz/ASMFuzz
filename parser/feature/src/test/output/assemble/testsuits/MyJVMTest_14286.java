import java.util.*;

public class MyJVMTest_14286 {

    static String str = "p5Q\\=9M).k";

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
        System.out.println(new MyJVMTest_14286().escapeToUnicode(str));
    }
}
