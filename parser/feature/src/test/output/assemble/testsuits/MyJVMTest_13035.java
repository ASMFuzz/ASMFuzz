public class MyJVMTest_13035 {

    static int[] ia = new int[] { 0x12345678 };

    int fcomp(int[] ia) {
        return Integer.bitCount(ia[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13035().fcomp(ia));
    }
}
