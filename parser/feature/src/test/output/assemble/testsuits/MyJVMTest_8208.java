public class MyJVMTest_8208 {

    static int i = 0;

    static int i1 = 3;

    static int i2 = -784548948;

    int test2(int i) {
        int j = 0;
        if (i > 0) {
            j = 1;
        }
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        int v1 = arr[j];
        arr[0] = 3;
        arr[1] = 4;
        return v1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8208().test2(i));
    }
}
