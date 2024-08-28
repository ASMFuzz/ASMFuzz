import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_2305 {

    static Element elem = null;

    View create(Element elem) {
        String kind = elem.getName();
        if (kind != null) {
            if (kind.equals(AbstractDocument.ContentElementName)) {
                return new LabelView(elem);
            } else if (kind.equals(AbstractDocument.ParagraphElementName)) {
                return new ParagraphView(elem);
            } else if (kind.equals(AbstractDocument.SectionElementName)) {
                return new BoxView(elem, View.Y_AXIS);
            } else if (kind.equals(StyleConstants.ComponentElementName)) {
                return new ComponentView(elem);
            } else if (kind.equals(CodeBugDocument.ELEMENT_TABLE)) {
                return new tableView(elem);
            } else if (kind.equals(StyleConstants.IconElementName)) {
                return new IconView(elem);
            }
        }
        return new LabelView(elem);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2305().create(elem));
    }
}
