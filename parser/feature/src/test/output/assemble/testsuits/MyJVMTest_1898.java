public class MyJVMTest_1898 {

    static CharSequence sb = null;

    static int seek = 0;

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
        System.out.println(new MyJVMTest_1898().previousSpaceIndex(sb, seek));
    }
}
