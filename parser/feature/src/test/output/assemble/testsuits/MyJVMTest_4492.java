import java.awt.Robot;

public class MyJVMTest_4492 {

    static boolean error = false;

    void validate() {
        if (this.error) {
            throw new Error("KeyStroke is null");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4492().validate();
    }
}
