public class MyJVMTest_815 {

    static int[] a = { 0, 6, -1814098093, 8, 578269274, 0, 0, 0, 5, 9 };

    int sumb2(int[] a) {
        Integer result1 = 1;
        Integer result2 = 1;
        for (Integer i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_815().sumb2(a));
    }
}
