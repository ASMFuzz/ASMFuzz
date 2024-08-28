public class MyJVMTest_2034 {

    static int[] a = { 2, 3, 0, 7, 0, 1970664852, 7, -546029100, 0, 9 };

    static int myKey = 5;

    static int myValue = 8;

    static long mySeed = -9223372036854775808L;

    Object convert(int[] a) {
        return a.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2034().convert(a));
    }
}
