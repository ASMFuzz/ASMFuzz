public class MyJVMTest_5902 {

    static int[] array = { 1834686731, 7, 8, 1543119768, 1, 0, 2, 0, 0, 5 };

    int[] test(int[] array) {
        for (int i = 1; i < 8; i += 3) {
            for (int j = 0; j < 4; ++j) {
                switch(i % 4) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        array[j] += 42;
                        break;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5902().test(array);
    }
}
