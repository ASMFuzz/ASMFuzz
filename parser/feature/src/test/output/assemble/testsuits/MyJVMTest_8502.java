public class MyJVMTest_8502 {

    static int i = 8;

    static int distance = 2;

    int rotateRight2(int i, int distance) {
        return ((i >>> distance) | (i << (32 - distance)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8502().rotateRight2(i, distance));
    }
}
