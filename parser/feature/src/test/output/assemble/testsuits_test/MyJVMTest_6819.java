public class MyJVMTest_6819 {

    static double v = 0d;

    Object save() {
        return new Double(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6819().save());
    }
}
