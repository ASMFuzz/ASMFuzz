public class MyJVMTest_11961 {

    static CharSequence seq = null;

    static boolean At = true, Before = false;

    int codePointCount(CharSequence seq) {
        int n = 0, len;
        for (int i = 0; i < seq.length(); i += len) {
            int codepoint = Character.codePointAt(seq, i);
            n++;
            len = Character.charCount(codepoint);
        }
        return n;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11961().codePointCount(seq));
    }
}
