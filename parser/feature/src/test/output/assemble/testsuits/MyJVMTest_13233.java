public class MyJVMTest_13233 {

    static boolean a = true;

    boolean not(boolean a) {
        return !a;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13233().not(a));
    }
}
