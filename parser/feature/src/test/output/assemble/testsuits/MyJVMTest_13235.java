public class MyJVMTest_13235 {

    static Object o = 0;

    void test8_2(Object o) {
    }

    I test8_1(Object o) {
        test8_2(o);
        return (I) o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13235().test8_1(o));
    }
}
