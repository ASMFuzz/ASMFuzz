public class MyJVMTest_6556 {

    A not_inlined() {
        return new A();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6556().not_inlined());
    }
}
