public class MyJVMTest_13265 {

    static short[] sa = new short[] { -1 };

    int loadS(short[] sa) {
        return sa[0];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13265().loadS(sa));
    }
}
