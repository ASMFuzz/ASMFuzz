public class MyJVMTest_9158 {

    Object initialValue() {
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9158().initialValue());
    }
}
