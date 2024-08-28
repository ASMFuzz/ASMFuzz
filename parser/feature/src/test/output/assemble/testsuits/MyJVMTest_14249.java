public class MyJVMTest_14249 {

    static int[] a = { 4, 0, 7, -11782989, 9, 9, 0, -1053905839, 0, 1587647314 };

    int sum(int[] a) {
        int result = 1;
        for (Integer i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14249().sum(a));
    }
}
