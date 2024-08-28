public class MyJVMTest_7830 {

    static double v = Double.MAX_VALUE;

    boolean isNaN() {
        return (v != v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7830().isNaN());
    }
}
