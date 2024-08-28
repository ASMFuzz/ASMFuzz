public class MyJVMTest_12687 {

    static double i = 0d;

    double simpleb(double i) {
        Double ib = Double.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12687().simpleb(i));
    }
}
