public class MyJVMTest_7019 {

    static int[] a = { 7, 6, 0, 0, 4, 0, 0, 6, 7, 7 };

    static Integer result = 2;

    int sump(int[] a, Integer result) {
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7019().sump(a, result));
    }
}
