public class MyJVMTest_11032 {

    static String key = "3*(\"Uqm5eS";

    char checkKey(String key) throws Exception {
        for (char c : key.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c) || c == '{' || c == '}' || c == '.') {
            } else {
                System.out.println("Illegal char [" + c + "] in key: " + key);
                throw new Exception();
            }
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11032().checkKey(key);
    }
}
