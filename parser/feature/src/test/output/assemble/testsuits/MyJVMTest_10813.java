public class MyJVMTest_10813 {

    static int i = 4;

    static int distance = 4732085;

    int rotateRight(int i, int distance) {
        return ((i >>> distance) | (i << -distance));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10813().rotateRight(i, distance));
    }
}
