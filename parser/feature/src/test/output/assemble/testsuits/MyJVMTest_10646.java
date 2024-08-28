public class MyJVMTest_10646 {

    static String osname = "{oZy\\_wFv^";

    static String osName = System.getProperty("os.name");

    boolean isOs(String osname) {
        return osName.toLowerCase().startsWith(osname.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10646().isOs(osname));
    }
}
