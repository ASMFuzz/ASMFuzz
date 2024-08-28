public class MyJVMTest_10551 {

    static int major = 0;

    static int minor = 7;

    int versionOf(int major, int minor) {
        return ((major & 0xFF) << 8) | (minor & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10551().versionOf(major, minor));
    }
}
