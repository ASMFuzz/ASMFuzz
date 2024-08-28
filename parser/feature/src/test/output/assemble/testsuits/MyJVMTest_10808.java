public class MyJVMTest_10808 {

    static int[] array = { 8, 0, 0, 0, 0, 1, 8, 9, 0, 1203290067 };

    int[] method(int[] array) {
        System.out.println("You gave me an array of ints");
        throw new RuntimeException();
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10808().method(array);
    }
}
