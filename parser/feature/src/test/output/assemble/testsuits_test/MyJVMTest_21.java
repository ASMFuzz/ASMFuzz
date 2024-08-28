public class MyJVMTest_21 {

    Object initialValue() {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_21().initialValue());
    }
}
