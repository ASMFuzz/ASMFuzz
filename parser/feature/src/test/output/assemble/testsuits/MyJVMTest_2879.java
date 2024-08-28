public class MyJVMTest_2879 {

    static int x = 0;

    static int[] array = { -583809785, 1, 0, 7, -1030406398, 8, 3, -1083751318, 5, 7 };

    boolean test1(int x, int[] array) {
        int m = array.length;
        if ((x & m) < 0 || (x & m) > m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2879().test1(x, array));
    }
}
