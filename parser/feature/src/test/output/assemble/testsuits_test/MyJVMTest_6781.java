public class MyJVMTest_6781 {

    void test() {
        String property = System.getProperty("os.name");
        System.out.println("property = " + property);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6781().test();
    }
}
