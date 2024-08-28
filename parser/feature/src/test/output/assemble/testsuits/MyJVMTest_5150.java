public class MyJVMTest_5150 {

    static Object in = -630070234;

    Class<Object> foo(Object in) {
        return Object.class;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5150().foo(in));
    }
}
