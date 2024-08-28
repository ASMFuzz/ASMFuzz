import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_14336 {

    static int numThreads = 3;

    void start() {
        allocator.start();
    }

    static Thread thread = null;

    static Allocator allocator = null;

    List<ThreadInformation> createThreadList(int numThreads) {
        List<ThreadInformation> threadList = new ArrayList<>();
        for (int i = 0; i < numThreads; i++) {
            Allocator allocator = new Allocator(i);
            Thread thread = new Thread(allocator, "Allocator" + i);
            ThreadInformation info = new ThreadInformation(thread, allocator);
            threadList.add(info);
            thread.start();
        }
        return threadList;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14336().createThreadList(numThreads));
    }
}
