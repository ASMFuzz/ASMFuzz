public class MyJVMTest_1084 {

    static T[] array = { 0f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NaN, Float.NaN, 0f, Float.POSITIVE_INFINITY };

    static int index = 8;

    <T> T getDefault(T[] array, int index) {
        return (index == -1) ? null : array[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1084().getDefault(array, index));
    }
}
