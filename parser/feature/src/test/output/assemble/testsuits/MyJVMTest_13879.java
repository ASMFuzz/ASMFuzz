import java.awt.Robot;

public class MyJVMTest_13879 {

    static boolean error = true;

    void validate() {
        if (this.error) {
            throw new Error("KeyStroke is null");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13879().validate();
    }
}
