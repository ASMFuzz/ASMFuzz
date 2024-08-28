import java.awt.*;

public class MyJVMTest_17803 {

    static Frame currentFrame = null;

    int getNextLocationY() {
        return currentFrame.getY();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17803().getNextLocationY());
    }
}
