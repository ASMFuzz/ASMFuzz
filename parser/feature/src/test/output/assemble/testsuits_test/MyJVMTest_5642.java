public class MyJVMTest_5642 {

    static T8198502 t = null;

    T8198502 test(T8198502 t) {
        throw new AssertionError("Should not be invoked!");
        return t;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5642().test(t);
    }
}
