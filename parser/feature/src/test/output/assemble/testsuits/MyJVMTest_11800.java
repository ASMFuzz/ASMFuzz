public class MyJVMTest_11800 {

    static float i = Float.MAX_VALUE;

    float simpleb(float i) {
        Float ib = Float.valueOf(i);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11800().simpleb(i));
    }
}
