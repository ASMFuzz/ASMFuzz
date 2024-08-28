import java.beans.Beans;

public class MyJVMTest_15804 {

    void run() {
        if (Beans.isDesignTime()) {
            throw new Error("shared DesignTime property");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15804().run();
    }
}
