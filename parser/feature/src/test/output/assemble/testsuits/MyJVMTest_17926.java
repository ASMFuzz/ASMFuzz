public class MyJVMTest_17926 {

    static int i = -1482588457;

    static int distance = 0;

    int rotateRight1(int i, int distance) {
        return ((i >>> distance) | (i << -distance));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17926().rotateRight1(i, distance));
    }
}
