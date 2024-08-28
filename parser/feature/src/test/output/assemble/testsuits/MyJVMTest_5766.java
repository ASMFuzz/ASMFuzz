public class MyJVMTest_5766 {

    static int[] array = { 0, 5, 6, -633734934, 7, 0, 7, 0, 4, 0 };

    boolean test4(int[] array) {
        if (array.length <= 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5766().test4(array));
    }
}
