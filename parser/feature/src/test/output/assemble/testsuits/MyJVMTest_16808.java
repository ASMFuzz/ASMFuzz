public class MyJVMTest_16808 {

    static int x = 8;

    long foo3() {
        return x & 0x8abcdef1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16808().foo3());
    }
}
