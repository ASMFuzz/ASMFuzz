public class MyJVMTest_16380 {

    static int[] a = { 0, -551202574, 7, -1276367415, 5, 6, -1518445960, 5, 1, 2 };

    int sum2(int[] a) {
        int result1 = 1;
        int result2 = 1;
        for (Integer i : a) {
            result1 += i;
            result2 += i + 1;
        }
        return result1 + result2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16380().sum2(a));
    }
}
