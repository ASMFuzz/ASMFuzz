public class MyJVMTest_4046 {

    static int[] array = { -534562493, 3, 8, 0, 7, 0, 6, -859917641, 9, -170235320 };

    int[] notInlined(int[] array) {
        java.util.Arrays.fill(array, 1);
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4046().notInlined(array);
    }
}
