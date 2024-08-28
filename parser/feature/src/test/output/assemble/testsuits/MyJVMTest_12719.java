public class MyJVMTest_12719 {

    static int count = 0;

    static int desiredValue = 3;

    boolean atDesiredValue() {
        return count == desiredValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12719().atDesiredValue());
    }
}
