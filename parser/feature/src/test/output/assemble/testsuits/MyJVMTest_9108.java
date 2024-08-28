public class MyJVMTest_9108 {

    static boolean useAAHints = false;

    String getName() {
        return "Custom L&F";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9108().getName());
    }
}
