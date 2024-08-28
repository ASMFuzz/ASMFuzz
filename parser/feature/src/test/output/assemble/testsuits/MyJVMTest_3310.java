public class MyJVMTest_3310 {

    static String archname = ";q]ox?hE%]";

    static String osArch = System.getProperty("os.arch");

    boolean isArch(String archname) {
        return osArch.toLowerCase().startsWith(archname.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3310().isArch(archname));
    }
}
