public class MyJVMTest_10041 {

    static String s = "1~Ey]?4ns+";

    String removePackage(String s) {
        int index = s.lastIndexOf(".");
        return s.substring(index + 1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10041().removePackage(s));
    }
}
