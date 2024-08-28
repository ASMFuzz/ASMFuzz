import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class MyJVMTest_1460 {

    static IIOMetadataNode root = new IIOMetadataNode();

    static String name = "&E*3hK>-Gd";

    static Object object = 9;

    static String nativeMetadataFormatName = "simp_metadata_1.0";

    static int width = 5, height = 0;

    IIOMetadataNode addChildNode(IIOMetadataNode root, String name, Object object) {
        IIOMetadataNode child = new IIOMetadataNode(name);
        if (object != null) {
            child.setUserObject(object);
            child.setNodeValue(object.toString());
        }
        root.appendChild(child);
        return child;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1460().addChildNode(root, name, object));
    }
}
