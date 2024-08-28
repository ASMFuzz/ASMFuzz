public class MyJVMTest_2913 {

    static int[] a = { 2, 0, 0, 1786112320, 2, -1107464027, 8, 332382418, 8, 3 };

    static Integer ibc = new Integer(1);

    int sumc2(int[] a) {
        Integer result1 = 1;
        Integer result2 = ibc;
        for (Integer i : a) {
            result1 += i;
            result2 += i + ibc;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2913().sumc2(a));
    }
}
