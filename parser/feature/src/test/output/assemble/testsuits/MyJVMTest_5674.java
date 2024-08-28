public class MyJVMTest_5674 {

    static char[] chars = { ')', '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'd', 'S' };

    String test(char[] chars) {
        try {
            return new String(chars, -1, 42);
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5674().test(chars));
    }
}
