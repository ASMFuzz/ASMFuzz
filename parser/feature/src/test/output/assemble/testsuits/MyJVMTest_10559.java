public class MyJVMTest_10559 {

    static double arg = Double.MAX_VALUE;

    String print(double arg) {
        return String.valueOf(arg);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10559().print(arg));
    }
}
