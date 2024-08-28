public class MyJVMTest_10380 {

    static Integer I = 0;

    static int i = 0;

    static Integer II = new Integer(42);

    Integer m2(Integer I, int i) {
        for (; i < 10; i = (i + 2) * (i + 2)) {
        }
        if (i == 121) {
            return II;
        }
        return I;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10380().m2(I, i));
    }
}
