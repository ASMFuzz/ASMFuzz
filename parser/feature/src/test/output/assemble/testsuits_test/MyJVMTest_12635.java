public class MyJVMTest_12635 {

    static String archname = "E*[=p\"q]oe";

    static String osArch = System.getProperty("os.arch");

    boolean isArch(String archname) {
        return osArch.toLowerCase().startsWith(archname.toLowerCase());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12635().isArch(archname));
    }
}
