public class MyJVMTest_5335 {

    void f() {
        Byte b = 12;
        Byte c = 'a';
        Short s = 'b';
        Short t = 12;
        Character d = 12;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5335().f();
    }
}
