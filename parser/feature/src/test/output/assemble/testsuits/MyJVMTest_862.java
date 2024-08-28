public class MyJVMTest_862 {

    static String s = "S$4}eXW\\P1";

    String removePackage(String s) {
        int index = s.lastIndexOf(".");
        return s.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_862().removePackage(s));
    }
}
