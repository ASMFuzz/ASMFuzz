public class MyJVMTest_3732 {

    boolean isMac() {
        String osName = System.getProperty("os.name");
        return osName.contains("Mac");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3732().isMac());
    }
}
