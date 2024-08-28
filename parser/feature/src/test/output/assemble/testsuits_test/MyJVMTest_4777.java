public class MyJVMTest_4777 {

    static Object[] array = { 8, -730273864, 6, 1, 3, 9, 1024619539, 0, 6, 3 };

    Object[] test(Object[] array) {
        array[0] = "1";
        array[array.length - 1] = "1";
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4777().test(array);
    }
}
