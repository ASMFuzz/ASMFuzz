public class MyJVMTest_6667 {

    static int index = 1;

    static int[] array = new int[100];

    int testArrayAccess2(int index) {
        int storeIndex = Integer.MIN_VALUE;
        for (; index < 10; ++index) {
            if (index == 42) {
                return array[storeIndex - 1];
            }
            storeIndex = 0;
        }
        return array[42];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6667().testArrayAccess2(index));
    }
}
