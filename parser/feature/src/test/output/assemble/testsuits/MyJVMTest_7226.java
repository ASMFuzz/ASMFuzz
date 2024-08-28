public class MyJVMTest_7226 {

    static IllegalSignature<?> outer = null;

    IllegalSignature<?> test(IllegalSignature<?> outer) {
        outer.new Inner() {
        };
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7226().test(outer);
    }
}
