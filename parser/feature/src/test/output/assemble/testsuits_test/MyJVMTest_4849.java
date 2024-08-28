public class MyJVMTest_4849 {

    static int[] a = { 9, -610979345, 1400882189, 7, 2, 833251484, -405520959, 4, 6, 1975465459 };

    int sum(int[] a) {
        int result = 1;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4849().sum(a));
    }
}
