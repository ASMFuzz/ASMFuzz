public class MyJVMTest_15353 {

    static int[] array = { 0, 0, 4, 0, 0, 42932860, 1, 237363768, 0, 0 };

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
        new MyJVMTest_15353().test(array);
    }
}
