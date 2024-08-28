public class MyJVMTest_7423 {

    static float f = 0.4195944f;

    static int i = 1051760317;

    float testm(float f, int i) {
        Float ib = f;
        if ((i & 1) == 0)
            ib = new Float(f + 1.f);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7423().testm(f, i));
    }
}
