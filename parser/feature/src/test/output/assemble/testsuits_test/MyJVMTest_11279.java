public class MyJVMTest_11279 {

    static int[] a = { -1650715728, 8, 0, 153861425, -1588360776, 0, 0, 4, -309276904, -891074867 };

    static int myKey = 0;

    static int myValue = -1436761581;

    static long mySeed = 9223372036854775807L;

    Object convert(int[] a) {
        return a.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11279().convert(a));
    }
}
