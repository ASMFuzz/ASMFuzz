import java.awt.Color;

public class MyJVMTest_9478 {

    static int currentIndex = 0;

    void nextColor() {
        currentIndex++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9478().nextColor();
    }
}
