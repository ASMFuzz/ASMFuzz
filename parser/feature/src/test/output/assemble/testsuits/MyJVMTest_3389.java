public class MyJVMTest_3389 {

    static int count = 0;

    static int desiredValue = 0;

    boolean atDesiredValue() {
        return count == desiredValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3389().atDesiredValue());
    }
}
