public class MyJVMTest_51 {

    static int i = 3;

    int javaMethod(int i) {
        int k = 0;
        for (int j = 0; j < i; j++) {
            k += (i - j);
        }
        return k;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_51().javaMethod(i));
    }
}
