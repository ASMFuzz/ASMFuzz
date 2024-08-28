public class MyJVMTest_14112 {

    static Object paramObject = 0;

    boolean foo(Object paramObject) {
        System.out.println("foo");
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14112().foo(paramObject));
    }
}
