public class MyJVMTest_1587 {

    static int[] array = { 336042012, 1, -1837812027, 647785479, -786555028, 6, 5, 3, 1, 5 };

    int[] method(int[] array) {
        System.out.println("You gave me an array of ints");
        throw new RuntimeException();
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1587().method(array);
    }
}
