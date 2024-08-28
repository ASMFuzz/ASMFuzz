public class MyJVMTest_1350 {

    static double arg = Double.NaN;

    String print(double arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1350().print(arg));
    }
}
