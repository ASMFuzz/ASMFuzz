public class MyJVMTest_8953 {

    static int major = 0;

    static int minor = 0;

    int versionOf(int major, int minor) {
        return ((major & 0xFF) << 8) | (minor & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8953().versionOf(major, minor));
    }
}
