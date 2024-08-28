public class MyJVMTest_1343 {

    static int major = 8;

    static int minor = 0;

    int versionOf(int major, int minor) {
        return ((major & 0xFF) << 8) | (minor & 0xFF);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1343().versionOf(major, minor));
    }
}
