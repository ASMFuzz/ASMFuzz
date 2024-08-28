public class MyJVMTest_2709 {

    static int[] array = { 0, 0, 0, 9, 735845156, 0, -433141690, -1109515554, -1671300217, 0 };

    boolean test5(int[] array) {
        if (array.length == 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2709().test5(array));
    }
}
