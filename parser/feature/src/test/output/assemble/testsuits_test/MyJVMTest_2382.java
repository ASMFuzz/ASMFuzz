public class MyJVMTest_2382 {

    static int[] a = { 9, 1784551797, 1988739516, 0, 9, 0, 4, -17692398, 6, 0 };

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
        System.out.println(new MyJVMTest_2382().sump2(a, result2));
    }
}
