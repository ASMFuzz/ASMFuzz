public class MyJVMTest_11645 {

    static int[] a = { -1818547814, 4, 0, 6, 1, 0, 8, 5, 518635940, 0 };

    static Integer result2 = 0;

    int sump2(int[] a, Integer result2) {
        Integer result1 = 1;
        for (Integer i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11645().sump2(a, result2));
    }
}
