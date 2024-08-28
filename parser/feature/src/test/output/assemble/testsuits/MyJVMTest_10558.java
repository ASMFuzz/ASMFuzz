public class MyJVMTest_10558 {

    static int value = -977626575;

    long longValue() {
        return (long) value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10558().longValue());
    }
}
