public class MyJVMTest_18162 {

    static int i = 0;

    int lzcomp(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18162().lzcomp(i));
    }
}
