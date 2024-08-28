import java.awt.ComponentOrientation;

public class MyJVMTest_14349 {

    static ComponentOrientation orientation = null;

    String getOrientation(ComponentOrientation orientation) {
        return orientation == ComponentOrientation.LEFT_TO_RIGHT ? "LEFT_TO_RIGHT" : "RIGHT_TO_LEFT";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14349().getOrientation(orientation));
    }
}
