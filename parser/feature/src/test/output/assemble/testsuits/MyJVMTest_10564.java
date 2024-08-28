public class MyJVMTest_10564 {

    static int l = 815020595;

    String align(int l) {
        String shift = "";
        for (int i = 0; i < l; i++) {
            shift += "    ";
        }
        return shift;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10564().align(l));
    }
}
