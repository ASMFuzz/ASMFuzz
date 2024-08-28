public class MyJVMTest_16051 {

    A not_inlined() {
        return new A();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16051().not_inlined());
    }
}
