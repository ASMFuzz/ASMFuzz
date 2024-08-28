public class MyJVMTest_1807 {

    static String key = "_3];]~'|Te";

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
        new MyJVMTest_1807().checkKey(key);
    }
}
