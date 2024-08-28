public class MyJVMTest_12790 {

    int getValue() {
        return 3;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12790().getValue());
    }
}
