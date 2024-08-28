public class MyJVMTest_14565 {

    static Object in = 8;

    Class<Object> foo(Object in) {
        return Object.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14565().foo(in));
    }
}
