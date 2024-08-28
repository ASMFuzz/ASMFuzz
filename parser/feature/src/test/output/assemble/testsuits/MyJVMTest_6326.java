import java.beans.Beans;

public class MyJVMTest_6326 {

    void run() {
        if (Beans.isDesignTime()) {
            throw new Error("shared DesignTime property");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6326().run();
    }
}
