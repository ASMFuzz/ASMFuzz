import javax.swing.*;

public class MyJVMTest_6517 {

    Object createPublicValue() {
        return new UIDefaults.ProxyLazyValue("javax.swing.UIDefaults").createValue(null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6517().createPublicValue());
    }
}
