public class MyJVMTest_16415 {

    static float v = Float.POSITIVE_INFINITY;

    Object save() {
        return new Float(v);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16415().save());
    }
}
