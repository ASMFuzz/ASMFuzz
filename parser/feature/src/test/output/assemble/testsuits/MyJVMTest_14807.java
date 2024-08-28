public class MyJVMTest_14807 {

    static String s = "?~{34}xQ!t";

    String test(String s) {
        assert s == "Yup";
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14807().test(s);
    }
}
