import java.io.Serializable;

public class MyJVMTest_5726 {

    static TypeAnnotatedTestClass arg = null;

    Class myMethod(@InvisTypeAnn @TestAnn(site = "formalParameterAnnotation") TypeAnnotatedTestClass arg) throws @TestAnn(site = "throwsAnnotation") ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5726().myMethod(arg));
    }
}
