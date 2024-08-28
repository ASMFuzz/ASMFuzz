public class MyJVMTest_5202 {

    static float i = Float.NEGATIVE_INFINITY;

    Float foob(float i) {
        return Float.valueOf(i);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5202().foob(i));
    }
}
