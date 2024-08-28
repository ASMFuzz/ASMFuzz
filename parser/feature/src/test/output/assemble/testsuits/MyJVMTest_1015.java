public class MyJVMTest_1015 {

    static double i = Double.MIN_VALUE;

    Double foob(double i) {
        return Double.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1015().foob(i));
    }
}
