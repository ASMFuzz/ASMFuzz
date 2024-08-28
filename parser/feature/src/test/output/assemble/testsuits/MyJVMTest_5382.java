public class MyJVMTest_5382 {

    static String s = "I(W/%}wD?w";

    String test(String s) {
        assert s == "Yup";
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5382().test(s);
    }
}
