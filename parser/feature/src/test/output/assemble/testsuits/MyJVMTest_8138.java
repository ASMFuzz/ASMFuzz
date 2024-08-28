public class MyJVMTest_8138 {

    static double X = java.lang.Math.PI;

    static boolean b = false;

    boolean isX() {
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8138().isX());
    }
}
