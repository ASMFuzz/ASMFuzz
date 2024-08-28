public class MyJVMTest_2256 {

    Object run() {
        return System.getProperty("foo");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2256().run());
    }
}
