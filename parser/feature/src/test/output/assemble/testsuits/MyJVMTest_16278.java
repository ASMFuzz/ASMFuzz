public class MyJVMTest_16278 {

    void test() {
        String property = System.getProperty("os.name");
        System.out.println("property = " + property);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16278().test();
    }
}
