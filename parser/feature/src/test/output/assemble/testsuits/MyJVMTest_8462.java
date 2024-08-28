public class MyJVMTest_8462 {

    static short[] sa = new short[] { -1 };

    long loadS2L(short[] sa) {
        return sa[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8462().loadS2L(sa));
    }
}
