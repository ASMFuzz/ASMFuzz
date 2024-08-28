public class MyJVMTest_8570 {

    static int i = 4;

    int lzcomp(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8570().lzcomp(i));
    }
}
