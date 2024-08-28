public class MyJVMTest_6247 {

    static int first = 3;

    static int second = -213936630;

    boolean isEqual(final int first, final int second) {
        return (first == second);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6247().isEqual(first, second));
    }
}
