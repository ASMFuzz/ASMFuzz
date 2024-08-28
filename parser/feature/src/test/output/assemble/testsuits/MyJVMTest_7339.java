public class MyJVMTest_7339 {

    static int r = 6;

    static int[] arr = {0,4,0,0,0,6,7,1,4,-1850052725};

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
        System.out.println(new MyJVMTest_7339().test(r));
    }
}
