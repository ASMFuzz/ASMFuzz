public class MyJVMTest_9564 {

    static int[] ia = new int[] { 0x12345678 };

    int fint(int[] ia) {
        return Integer.bitCount(ia[0]);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9564().fint(ia));
    }
}
