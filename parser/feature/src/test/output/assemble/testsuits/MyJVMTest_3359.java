public class MyJVMTest_3359 {

    static double i = 0.06890161896260105;

    double simpleb(double i) {
        Double ib = Double.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3359().simpleb(i));
    }
}
