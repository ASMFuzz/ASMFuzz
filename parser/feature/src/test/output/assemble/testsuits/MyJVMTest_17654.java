public class MyJVMTest_17654 {

    static int[] a = { 0, 6, 5, 1781923339, 1244121185, -854642304, 1, 0, 0, 8 };

    int sumb(int[] a) {
        Integer result = 1;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17654().sumb(a));
    }
}
