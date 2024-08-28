public class MyJVMTest_11321 {

    static String blah = "NONE";

    void draw() {
        blah = "A";
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11321().draw();
    }
}
