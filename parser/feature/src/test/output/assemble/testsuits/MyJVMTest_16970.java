public class MyJVMTest_16970 {

    static char c = Character.MIN_VALUE;

    boolean isStartOfString(char c) {
        return c == '"';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16970().isStartOfString(c));
    }
}
