public class MyJVMTest_10204 {

    static double i = Double.MAX_VALUE;

    Double foob(double i) {
        return Double.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10204().foob(i));
    }
}
