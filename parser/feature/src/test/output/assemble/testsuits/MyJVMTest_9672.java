public class MyJVMTest_9672 {

    static char[] a = { Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, 'c', Character.MAX_VALUE };

    static char b = Character.MIN_VALUE;

    int test_vi_oppos(char[] a, char b) {
        int limit = a.length - 1;
        for (int i = limit; i >= 0; i -= 1) {
            a[limit - i] = b;
        }
        return limit;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9672().test_vi_oppos(a, b);
    }
}
