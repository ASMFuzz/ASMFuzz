import javax.swing.*;

public class MyJVMTest_8283 {

    Object createPrivateValue() {
        return new UIDefaults.ProxyLazyValue("javax.swing.MultiUIDefaults").createValue(null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8283().createPrivateValue());
    }
}
