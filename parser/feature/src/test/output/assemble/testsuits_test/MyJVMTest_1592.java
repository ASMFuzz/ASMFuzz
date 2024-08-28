public class MyJVMTest_1592 {

    static int i = 2;

    static int distance = 169002124;

    int rotateRight(int i, int distance) {
        return ((i >>> distance) | (i << -distance));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1592().rotateRight(i, distance));
    }
}
