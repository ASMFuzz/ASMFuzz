public class MyJVMTest_1349 {

    static int value = 5;

    long longValue() {
        return (long) value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1349().longValue());
    }
}
