public class MyJVMTest_7283 {

    static int x = -894339126;

    long foo3() {
        return x & 0x8abcdef1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7283().foo3());
    }
}
