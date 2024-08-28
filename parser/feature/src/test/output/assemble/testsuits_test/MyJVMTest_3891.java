public class MyJVMTest_3891 {

    static Object o = 6;

    void test8_2(Object o) {
    }

    I test8_1(Object o) {
        test8_2(o);
        return (I) o;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3891().test8_1(o));
    }
}
