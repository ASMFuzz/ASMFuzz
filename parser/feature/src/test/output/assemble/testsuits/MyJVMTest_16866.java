public class MyJVMTest_16866 {

    static int r = 0;

    static int[] arr = {1168105354,0,0,3,4,1738493384,4,83075201,6,4};

    int test(int r) {
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int a = 0;
                for (long k = 0; k < 100; k++) {
                    a += k;
                }
                if (arr != null)
                    a = arr[j];
                r += a;
            }
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16866().test(r));
    }
}
