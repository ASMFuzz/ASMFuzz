public class MyJVMTest_14816 {

    static char c = Character.MIN_VALUE;

    boolean isStartOfObject(char c) {
        return c == '{';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14816().isStartOfObject(c));
    }
}
