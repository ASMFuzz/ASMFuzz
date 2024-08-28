public class MyJVMTest_11168 {

    static boolean useAAHints = true;

    String getName() {
        return "Custom L&F";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11168().getName());
    }
}
