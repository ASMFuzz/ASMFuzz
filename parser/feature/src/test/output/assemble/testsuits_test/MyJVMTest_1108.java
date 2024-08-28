import javax.swing.*;

public class MyJVMTest_1108 {

    static int MAX_LEVEL = 2;

    static int level = 0;

    String doInBackground() throws Exception {
        if (level < MAX_LEVEL) {
            SwingWorker<String, Void> nested = new NestedWorkers(level + 1);
            nested.execute();
            nested.get();
        }
        System.out.println("doInBackground " + level + " is complete");
        return String.valueOf(level);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1108().doInBackground());
    }
}
