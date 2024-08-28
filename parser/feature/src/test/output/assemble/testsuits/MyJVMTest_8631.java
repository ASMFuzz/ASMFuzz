public class MyJVMTest_8631 {

    static long val = 6724262330780711037L;

    long testRorOrLong16(long val) {
        return (val >>> 16) | (val << (64 - 16));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8631().testRorOrLong16(val));
    }
}
