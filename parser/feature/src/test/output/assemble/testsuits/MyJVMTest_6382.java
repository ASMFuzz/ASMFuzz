public class MyJVMTest_6382 {

    static char c = '0';

    boolean isStartOfBoolean(char c) {
        return c == 't' || c == 'f';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6382().isStartOfBoolean(c));
    }
}
