import javax.swing.*;

public class MyJVMTest_17859 {

    Object createPrivateValue() {
        return new UIDefaults.ProxyLazyValue("javax.swing.MultiUIDefaults").createValue(null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17859().createPrivateValue());
    }
}
