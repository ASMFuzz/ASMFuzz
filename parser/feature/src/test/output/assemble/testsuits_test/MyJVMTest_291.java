public class MyJVMTest_291 {

    boolean isWindows() {
        return System.getProperty("os.name").toLowerCase().startsWith("win");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_291().isWindows());
    }
}
