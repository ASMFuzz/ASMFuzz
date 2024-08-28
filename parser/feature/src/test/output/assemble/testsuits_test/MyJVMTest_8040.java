public class MyJVMTest_8040 {

    static int[] a = { 0, 0, 3, 9, 7, 9, 6, 0, 0, 0 };

    int summ2(int[] a) {
        Integer result1 = 1;
        Integer result2 = new Integer(1);
        for (Integer i : a) {
            result1 += i;
            result2 += new Integer(i + 1);
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8040().summ2(a));
    }
}
