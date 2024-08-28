public class MyJVMTest_12501 {

    static int[] src = { -2097272377, 1011651661, 7, 0, 5, 9, 5, 6, 1, 8 };

    int[] clone_and_verify(int[] src) {
        for (int i = 0; i < src.length; i++) {
            int[] src_clone = src.clone();
            if (src[i] != src_clone[i]) {
                System.out.println("Error: allocated but not copied: ");
                for (int j = 0; j < src_clone.length; j++) System.out.print(" " + src_clone[j]);
                System.out.println();
                System.exit(97);
            }
        }
        return src;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12501().clone_and_verify(src);
    }
}
