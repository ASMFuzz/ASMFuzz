public class MyJVMTest_3819 {

    static char c = Character.MAX_VALUE;

    boolean isStartOfNull(char c) {
        return c == 'n';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3819().isStartOfNull(c));
    }
}
