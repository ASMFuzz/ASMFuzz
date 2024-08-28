public class MyJVMTest_13160 {

    static char c = Character.MIN_VALUE;

    boolean isStartOfNull(char c) {
        return c == 'n';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13160().isStartOfNull(c));
    }
}
