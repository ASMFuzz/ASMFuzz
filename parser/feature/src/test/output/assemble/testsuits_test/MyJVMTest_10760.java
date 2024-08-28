import java.lang.management.ManagementFactory;

public class MyJVMTest_10760 {

    long getHeapCommittedSize() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getCommitted() / 1024;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10760().getHeapCommittedSize());
    }
}
