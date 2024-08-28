public class MyJVMTest_17390 {

    static double v = Double.NaN;

    boolean isNaN() {
        return (v != v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17390().isNaN());
    }
}
