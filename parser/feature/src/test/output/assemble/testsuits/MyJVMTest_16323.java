public class MyJVMTest_16323 {

    static double v = Double.NEGATIVE_INFINITY;

    Object save() {
        return new Double(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16323().save());
    }
}
