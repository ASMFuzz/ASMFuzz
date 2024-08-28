public class MyJVMTest_8346 {

    static int i = 9;

    static int distance = 1740529708;

    int rotateRight1(int i, int distance) {
        return ((i >>> distance) | (i << -distance));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8346().rotateRight1(i, distance));
    }
}
