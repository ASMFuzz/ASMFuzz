public class MyJVMTest_13044 {

    <T extends String> void test() {
        MethodReferenceVarargsTest<T> bug = new MethodReferenceVarargsTest<>();
        java.util.function.Function<String, T> b = bug::invoke;
        java.util.function.Function<String, T> f = (args) -> bug.invoke(args);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13044().test();
    }
}
