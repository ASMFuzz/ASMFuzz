public class MyJVMTest_11929 {

    static double X = java.lang.Math.PI;

    static double u = 0d;

    static boolean b = false;

    boolean isX() {
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11929().isX());
    }
}
