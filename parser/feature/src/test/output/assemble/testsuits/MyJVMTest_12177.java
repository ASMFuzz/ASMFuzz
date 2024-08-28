public class MyJVMTest_12177 {

    static int x = 6;

    static int[] array = { 1337562590, 5, 362865132, 1681447471, 0, -310891078, -1729154269, 0, 0, 1912932691 };

    boolean test1(int x, int[] array) {
        int m = array.length;
        if ((x & m) < 0 || (x & m) > m) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12177().test1(x, array));
    }
}
