public class MyJVMTest_7531 {

    Integer getNumber() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7531().getNumber());
    }
}
