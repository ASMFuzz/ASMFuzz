public class MyJVMTest_18092 {

    static int i = 5;

    static int distance = -948723996;

    int rotateRight2(int i, int distance) {
        return ((i >>> distance) | (i << (32 - distance)));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18092().rotateRight2(i, distance));
    }
}
