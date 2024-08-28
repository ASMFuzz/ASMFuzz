public class MyJVMTest_16534 {

    static int[] a = { 9, 4, -1655884861, 0, 4, 4, 7, -1706281504, -222515613, 6 };

    static Integer result = 1;

    int sump(int[] a, Integer result) {
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16534().sump(a, result));
    }
}
