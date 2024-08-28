public class MyJVMTest_10986 {

    static double X = java.lang.Math.PI;

    static boolean b = true;

    boolean isX() {
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10986().isX());
    }
}
