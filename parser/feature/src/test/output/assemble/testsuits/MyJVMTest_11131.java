public class MyJVMTest_11131 {

    static CharSequence sb = null;

    static int seek = 2015893414;

    int previousSpaceIndex(CharSequence sb, int seek) {
        seek--;
        while (seek > 0) {
            if (sb.charAt(seek) == ' ') {
                while (seek > 0 && sb.charAt(seek - 1) == ' ') seek--;
                return seek;
            }
            seek--;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11131().previousSpaceIndex(sb, seek));
    }
}
