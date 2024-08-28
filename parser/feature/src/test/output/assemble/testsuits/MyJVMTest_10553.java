public class MyJVMTest_10553 {

    static int count = -987406881;

    static ClassLoader parent = null;

    boolean hack() {
        ++count;
        if ((count % 2) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10553().hack());
    }
}
