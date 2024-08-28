import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataNode;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class MyJVMTest_10676 {

    static IIOMetadataNode root = new IIOMetadataNode();

    static String name = "Go1%qjlTY\\";

    static Object object = 0;

    static String nativeMetadataFormatName = "simp_metadata_1.0";

    static int width = 5, height = -605925038;

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
        System.out.println(new MyJVMTest_10676().addChildNode(root, name, object));
    }
}
