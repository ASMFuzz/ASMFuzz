public class MyJVMTest_272 {

    static char c = Character.MIN_VALUE;

    boolean isStartOfArray(char c) {
        return c == '[';
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_272().isStartOfArray(c));
    }
}
