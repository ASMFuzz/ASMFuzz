public class MyJVMTest_15110 {

    static char[] chars = { '-', 't', '0', '0', 'k', 'h', 'C', ']', Character.MIN_VALUE, Character.MAX_VALUE };

    String test(char[] chars) {
        try {
            return new String(chars, -1, 42);
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15110().test(chars));
    }
}
