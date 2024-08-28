public class MyJVMTest_12931 {

    static int[] array = { 9, -851996096, 5, 6, 133860299, 7, 0, 0, 1156343555, 0 };

    boolean test6(int[] array) {
        if (array.length != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12931().test6(array));
    }
}
