public class MyJVMTest_8975 {

    static int value = 7;

    long longValue() {
        return (long) value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8975().longValue());
    }
}
