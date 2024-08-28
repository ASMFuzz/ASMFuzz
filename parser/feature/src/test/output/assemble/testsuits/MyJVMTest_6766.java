public class MyJVMTest_6766 {

    static String thisStr = "mTZTMz!RvQ";

    void init() {
        thisStr = this.toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6766().init();
    }
}
