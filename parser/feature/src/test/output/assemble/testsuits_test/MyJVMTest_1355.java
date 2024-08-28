public class MyJVMTest_1355 {

    static int l = 80243686;

    String align(int l) {
        String shift = "";
        for (int i = 0; i < l; i++) {
            shift += "    ";
        }
        return shift;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1355().align(l));
    }
}
