public class MyJVMTest_2075 {

    static String blah = "NONE";

    void draw() {
        blah = "A";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2075().draw();
    }
}
