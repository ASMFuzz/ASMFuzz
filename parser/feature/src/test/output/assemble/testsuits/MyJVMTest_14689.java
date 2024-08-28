public class MyJVMTest_14689 {

    static String compiler = System.getProperty("sun.management.compiler");

    boolean isTieredSupported() {
        return compiler.contains("Tiered Compilers");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14689().isTieredSupported());
    }
}
