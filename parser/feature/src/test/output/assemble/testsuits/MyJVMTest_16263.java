public class MyJVMTest_16263 {

    static String thisStr = "**p\"agIja\"";

    void init() {
        thisStr = this.toString();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16263().init();
    }
}
