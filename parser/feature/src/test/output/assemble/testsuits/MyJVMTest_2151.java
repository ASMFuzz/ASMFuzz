import org.w3c.dom.Node;

public class MyJVMTest_2151 {

    static Node node = null;

    String test(Node node) {
        String textContent = node.getTextContent();
        String nodeValue = node.getNodeValue();
        return textContent + ":" + nodeValue;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2151().test(node));
    }
}
