public class MyJVMTest_15863 {

    static char c = Character.MIN_VALUE;

    boolean isStartOfBoolean(char c) {
        return c == 't' || c == 'f';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15863().isStartOfBoolean(c));
    }
}
