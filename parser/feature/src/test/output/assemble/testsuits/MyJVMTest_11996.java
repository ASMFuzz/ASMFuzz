public class MyJVMTest_11996 {

    static int[] array = { 9, 3, 3, 3, 236632652, 2, 0, 0, 5, 0 };

    boolean test5(int[] array) {
        if (array.length == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11996().test5(array));
    }
}
