public class MyJVMTest_2647 {

    static double X = java.lang.Math.PI;

    static double u = Double.MIN_VALUE;

    static boolean b = false;

    boolean isX() {
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2647().isX());
    }
}
