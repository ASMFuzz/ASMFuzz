public class MyJVMTest_1763 {

    static double X = java.lang.Math.PI;

    static boolean b = false;

    boolean isX() {
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1763().isX());
    }
}
