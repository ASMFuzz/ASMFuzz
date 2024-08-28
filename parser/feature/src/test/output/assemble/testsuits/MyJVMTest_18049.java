public class MyJVMTest_18049 {

    static short[] sa = new short[] { -1 };

    long loadS2L(short[] sa) {
        return sa[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18049().loadS2L(sa));
    }
}
