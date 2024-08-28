public class MyJVMTest_15976 {

    void skipWhitespace() {
        while ((index < buffer.length()) && Character.isWhitespace(buffer.charAt(index))) {
            index++;
        }
    }

    static int index = 0;

    static String buffer = ",US7qfz*5#";

    String token() throws Exception {
        String tok = "";
        skipWhitespace();
        while ((index < buffer.length()) && !Character.isWhitespace(buffer.charAt(index))) {
            char delim = buffer.charAt(index);
            if ((delim == '"') || (delim == '\'')) {
                index++;
                int i = index;
                while ((i < buffer.length()) && (buffer.charAt(i) != delim)) {
                    i++;
                }
                if (i == buffer.length()) {
                    throw new Exception("TEST CMD FORMAT ERROR: Quote is missing in the path of .jar file: " + buffer);
                }
                tok += buffer.substring(index, i);
                index = i + 1;
            } else {
                int i = index;
                while ((i < buffer.length()) && (buffer.charAt(i) != '"') && !Character.isWhitespace(buffer.charAt(i))) {
                    i++;
                }
                tok += buffer.substring(index, i);
                index = i;
            }
        }
        return tok;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15976().token());
    }
}
