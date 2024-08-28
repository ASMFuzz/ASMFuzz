public class MyJVMTest_984 {

    int tzcomp(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    static int VALUE = 4;

    int dotzcomp() {
        return tzcomp(VALUE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_984().dotzcomp());
    }
}
