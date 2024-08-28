public class MyJVMTest_738 {

    ThreadGroup getSystemThreadGroup() {
        ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup parentThreadGroup = currentThreadGroup.getParent();
        while (parentThreadGroup != null) {
            currentThreadGroup = parentThreadGroup;
            parentThreadGroup = currentThreadGroup.getParent();
        }
        return currentThreadGroup;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_738().getSystemThreadGroup());
    }
}
