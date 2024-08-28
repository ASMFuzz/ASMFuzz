public class MyJVMTest_1433 {

    static String osname = "1qlrnW^Dw:";

    static String osName = System.getProperty("os.name");

    boolean isOs(String osname) {
        return osName.toLowerCase().startsWith(osname.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1433().isOs(osname));
    }
}
