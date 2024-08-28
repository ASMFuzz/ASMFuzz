public class MyJVMTest_12344 {

    static String mxBeanName = "'Xwfu2|:,=";

    Exitable startMemoryUser(String mxBeanName) {
        MemoryUser task = new MemoryUser(mxBeanName);
        Thread thread = new Thread(task);
        thread.setName("Memory User");
        thread.start();
        return task;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12344().startMemoryUser(mxBeanName));
    }
}
