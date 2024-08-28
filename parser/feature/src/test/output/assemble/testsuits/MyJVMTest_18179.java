public class MyJVMTest_18179 {

    static String s = ";E1h\"<3pTU";

    static char HYPHEN = '-';

    int getExtentionKeyIndex(String s) {
        char[] c = s.toCharArray();
        int index = Integer.MIN_VALUE;
        for (int i = 1; i < c.length; i++) {
            if (c[i] == HYPHEN) {
                if (i - index == 2) {
                    return index;
                } else {
                    index = i;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18179().getExtentionKeyIndex(s));
    }
}
