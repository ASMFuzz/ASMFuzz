public class MyJVMTest_15358 {

    static short[] sa = new short[] { -1 };

    int loadUS(short[] sa) {
        return sa[0] & 0xFFFF;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15358().loadUS(sa));
    }
}
