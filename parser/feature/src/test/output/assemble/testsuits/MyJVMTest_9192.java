public class MyJVMTest_9192 {

    static int i = 1;

    int javaMethod(int i) {
        int k = 0;
        for (int j = 0; j < i; j++) {
            k += (i - j);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9192().javaMethod(i));
    }
}
