public class MyJVMTest_646 {

    static int[] src = { 0, 0, 9, 1, -1002191448, 5, 2, 3, 873756554, 70109804 };

    int test2(int[] src) {
        System.arraycopy(src, 0, src, 0, 10);
        return src[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_646().test2(src));
    }
}
