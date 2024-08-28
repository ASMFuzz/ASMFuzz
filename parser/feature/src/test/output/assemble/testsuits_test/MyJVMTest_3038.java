public class MyJVMTest_3038 {

    static String mxBeanName = "Ow)&Z(n(O|";

    Exitable startMemoryUser(String mxBeanName) {
        MemoryUser task = new MemoryUser(mxBeanName);
        Thread thread = new Thread(task);
        thread.setName("Memory User");
        thread.start();
        return task;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3038().startMemoryUser(mxBeanName));
    }
}
