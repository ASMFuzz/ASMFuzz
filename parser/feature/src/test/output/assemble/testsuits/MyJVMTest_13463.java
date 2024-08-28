import java.util.Hashtable;

public class MyJVMTest_13463 {

    void run() {
        try {
            Hashtable originalObject = new Hashtable();
            synchronized (originalObject) {
                Hashtable clonedHashtable = (Hashtable) originalObject.clone();
                clonedHashtable.notify();
            }
        } catch (IllegalMonitorStateException e) {
            return;
        } catch (Exception e) {
            System.out.println("caught something unexpected:");
            e.printStackTrace();
            throw new RuntimeException();
        }
        throw new RuntimeException("illegal monitor state should have been thrown");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13463().run();
    }
}
