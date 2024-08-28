public class MyJVMTest_18138 {

    static GetInteger getter = null;

    GetInteger m(GetInteger getter) {
        throw new AssertionError("Less-specific method invocation: " + getter.getClass());
        return getter;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18138().m(getter);
    }
}
