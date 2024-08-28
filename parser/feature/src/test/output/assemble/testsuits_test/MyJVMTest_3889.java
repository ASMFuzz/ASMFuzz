public class MyJVMTest_3889 {

    static boolean a = false;

    boolean not(boolean a) {
        return !a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3889().not(a));
    }
}
