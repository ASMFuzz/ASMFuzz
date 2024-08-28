public class MyJVMTest_2170 {

    static int i = 6;

    int tzcomp(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2170().tzcomp(i));
    }
}
