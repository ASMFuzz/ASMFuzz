public class MyJVMTest_4915 {

    void test() {
        try {
            java.lang.reflect.Array.newInstance(void.class, 2);
        } catch (IllegalArgumentException e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4915().test();
    }
}
