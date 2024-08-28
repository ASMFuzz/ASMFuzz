public class MyJVMTest_15209 {

    static int[] array = { 7, 8, 8, -1226428467, 3, 0, 0, 3, 820013086, -1247027415 };

    boolean test4(int[] array) {
        if (array.length <= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15209().test4(array));
    }
}
