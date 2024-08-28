import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_7546 {

    static List<Foo> fooObject = new ArrayList<Foo>();

    List<Foo> getFooObject() {
        if (fooObject == null) {
            fooObject = new ArrayList<Foo>();
        }
        return this.fooObject;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7546().getFooObject());
    }
}
