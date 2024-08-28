public class MyJVMTest_7437 {

    static char c = ',';

    boolean isStartOfString(char c) {
        return c == '"';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7437().isStartOfString(c));
    }
}
