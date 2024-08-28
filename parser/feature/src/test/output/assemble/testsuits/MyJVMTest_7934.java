public class MyJVMTest_7934 {

    static int[] src = { 0, 0, 449220653, 1404991978, 5, 2, 6, 0, 0, 3 };

    static int[] ref = { 664034580, 0, -1415451401, 5, 3, 0, 0, -688448811, 7, 0 };

    int[] verify(int[] src, int[] ref) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] != ref[i]) {
                System.out.println("Error: src and ref don't match at " + i);
                System.exit(97);
            }
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7934().verify(src, ref);
    }
}
