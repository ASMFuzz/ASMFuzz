import java.util.HashSet;
import java.util.Set;

public class MyJVMTest_10064 {

    static String s = "/qLgFY\\v-o";

    Set<String> parseSetting(String s) {
        Set<String> stringSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean inString = false;
        for (int index = 0; index < s.length(); index++) {
            char c = s.charAt(index);
            if (c != '"') {
                if (inString) {
                    if (c == '\\' && index + 1 < s.length()) {
                        if (s.charAt(index + 1) == '"') {
                            index++;
                            c = '"';
                        }
                    }
                    sb.append(c);
                }
            } else {
                if (inString) {
                    stringSet.add(sb.toString());
                    sb.setLength(0);
                }
                inString = !inString;
            }
        }
        return stringSet;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10064().parseSetting(s));
    }
}
