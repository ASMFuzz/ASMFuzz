import java.util.*;

public class MyJVMTest_10671 {

    static String str = ";UMqlL&upf";

    String encodeHtml(String str) {
        final int len = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (ch == '<') {
                sb.append("&lt;");
            } else if (ch == '>') {
                sb.append("&gt;");
            } else if (ch == '"') {
                sb.append("&quot;");
            } else if (ch == '\'') {
                sb.append("&#039;");
            } else if (ch == '&') {
                sb.append("&amp;");
            } else if (ch < ' ') {
                sb.append("&#").append((int) ch).append(';');
            } else {
                int c = (ch & 0xFFFF);
                if (c > 127) {
                    sb.append("&#").append(c).append(';');
                } else {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10671().encodeHtml(str));
    }
}
