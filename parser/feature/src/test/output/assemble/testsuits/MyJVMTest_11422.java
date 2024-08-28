public class MyJVMTest_11422 {

    static int i = 9;

    int tzcomp(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11422().tzcomp(i));
    }
}
