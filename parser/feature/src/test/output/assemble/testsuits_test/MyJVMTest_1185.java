public class MyJVMTest_1185 {

    static int[] array = { 1, 0, 3, 0, -442672522, 9, 0, 4, 7, 5 };

    int m(int[] array) {
        int c = 0;
        for (int i = 0; i < 256; i++) {
            c += array[i];
            array[i] = c;
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1185().m(array));
    }
}
