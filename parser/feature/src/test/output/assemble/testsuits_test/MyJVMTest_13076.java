public class MyJVMTest_13076 {

    int getValue() {
        return 2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13076().getValue());
    }
}
