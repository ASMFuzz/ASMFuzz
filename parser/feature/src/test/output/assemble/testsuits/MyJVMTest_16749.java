public class MyJVMTest_16749 {

    static IllegalSignature<?> outer = null;

    IllegalSignature<?> test(IllegalSignature<?> outer) {
        outer.new Inner() {
        };
        return outer;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16749().test(outer);
    }
}
