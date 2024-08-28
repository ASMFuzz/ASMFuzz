public class MyJVMTest_17709 {

    static double X = java.lang.Math.PI;

    static boolean b = true;

    boolean isX() {
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17709().isX());
    }
}
