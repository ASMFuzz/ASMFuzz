public class MyJVMTest_10278 {

    static T[] array = { 0d, Double.MIN_VALUE, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, 0.053062265703069156 };

    static int index = 0;

    <T> T getDefault(T[] array, int index) {
        return (index == -1) ? null : array[index];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10278().getDefault(array, index));
    }
}
