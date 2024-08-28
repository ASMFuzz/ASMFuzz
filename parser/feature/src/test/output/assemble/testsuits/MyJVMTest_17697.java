public class MyJVMTest_17697 {

    static char[] a1 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE };

    int test_sum(char[] a1) {
        int sum = 0;
        for (int i = 0; i < a1.length; i += 1) {
            sum += a1[i];
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17697().test_sum(a1));
    }
}
