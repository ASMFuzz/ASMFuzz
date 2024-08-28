public class MyJVMTest_12212 {

    static int[] a = { 1489217172, 8, 0, 1, 7, 3, 9, 0, -1362170441, 0 };

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
        System.out.println(new MyJVMTest_12212().sumc2(a));
    }
}
