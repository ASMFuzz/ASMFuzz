import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class MyJVMTest_6426 {

    static NodeList list = null;

    String test(NodeList list) {
        Node node = list.item(0);
        return "[" + node.getNodeName() + ":" + node.getTextContent() + "]";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6426().test(list));
    }
}
