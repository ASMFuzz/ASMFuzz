public class MyJVMTest_10170 {

    int tzcomp(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    static int VALUE = 0;

    int dotzcomp() {
        return tzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10170().dotzcomp());
    }
}
