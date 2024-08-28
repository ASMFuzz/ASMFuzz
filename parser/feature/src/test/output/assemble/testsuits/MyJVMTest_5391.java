public class MyJVMTest_5391 {

    static char c = Character.MAX_VALUE;

    boolean isStartOfObject(char c) {
        return c == '{';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5391().isStartOfObject(c));
    }
}
