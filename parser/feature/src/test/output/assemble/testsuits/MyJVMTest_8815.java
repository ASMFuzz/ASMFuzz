public class MyJVMTest_8815 {

    static int count = -771968436;

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
        System.out.println(new MyJVMTest_8815().hack());
    }
}
