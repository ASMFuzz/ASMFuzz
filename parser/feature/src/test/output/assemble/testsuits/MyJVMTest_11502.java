public class MyJVMTest_11502 {

    static String name = "/Q~8xh%;=f";

    String transform(String name) {
        StringBuilder sb = new StringBuilder();
        boolean toLower = true;
        boolean toUpper = false;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == '.' || c == '_') {
                toLower = false;
                toUpper = true;
            } else {
                if (toUpper) {
                    toUpper = false;
                    sb.append(Character.toUpperCase(c));
                } else if (toLower) {
                    sb.append(Character.toLowerCase(c));
                } else {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11502().transform(name));
    }
}
