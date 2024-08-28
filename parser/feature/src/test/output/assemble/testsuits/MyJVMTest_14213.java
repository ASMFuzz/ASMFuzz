public class MyJVMTest_14213 {

    static int[] staticArr = new int[42];

    int testStaticField() {
        try {
            return staticArr.length;
        } catch (Throwable t) {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14213().testStaticField());
    }
}
