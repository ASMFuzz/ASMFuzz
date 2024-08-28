public class MyJVMTest_15682 {

    static int i = 0;

    int tzint(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15682().tzint(i));
    }
}
