public class MyJVMTest_14290 {

    static String s = "^v,8\\7a}*#";

    static int MAXLEN = 127;

    String normalize(String s) throws Exception {
        boolean needDot = false;
        int n = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                n++;
            else
                n = -10000;
        }
        if (n == 1)
            return "SPACE";
        else if (n > 1)
            return "" + n + "SPACE";
        StringBuilder sb = new StringBuilder();
        int dotpos = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || Character.isDigit(c) || c == '{' || c == '}') {
                if (needDot) {
                    if (sb.length() <= MAXLEN)
                        dotpos = sb.length();
                    sb.append(".");
                }
                sb.append(c);
                needDot = false;
            } else {
                needDot = true;
            }
        }
        if (sb.length() == 0) {
            if (s.contains("*") && s.contains("\n")) {
                return "STARNN";
            }
            for (char c : s.toCharArray()) {
                switch(c) {
                    case '*':
                        return "STAR";
                    case ',':
                        return "COMMA";
                    case '.':
                        return "PERIOD";
                    case '\n':
                        return "NEWLINE";
                    case '(':
                        return "LPARAM";
                    case ')':
                        return "RPARAM";
                    case ':':
                        return "COLON";
                    case '\'':
                    case '"':
                        return "QUOTE";
                }
            }
            throw new Exception("Unnamed char: [" + s + "]");
        }
        if (needDot)
            sb.append('.');
        String res = sb.toString();
        if (res.length() > MAXLEN) {
            if (dotpos < 0)
                throw new Exception("No dot all over? " + s);
            return res.substring(0, dotpos);
        } else {
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14290().normalize(s));
    }
}
