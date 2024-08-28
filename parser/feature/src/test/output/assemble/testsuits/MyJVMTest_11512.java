public class MyJVMTest_11512 {

    Object run() {
        return System.getProperty("foo");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11512().run());
    }
}
