public class MyJVMTest_14175 {

    static Object[] array = { -1517323374, 4, 2, 2, 0, 3, 6, 5, 8, 4 };

    Object[] test(Object[] array) {
        array[0] = "1";
        array[array.length - 1] = "1";
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14175().test(array);
    }
}
