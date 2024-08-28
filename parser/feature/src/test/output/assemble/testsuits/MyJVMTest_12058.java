import javax.annotation.processing.ProcessingEnvironment;

public class MyJVMTest_12058 {

    static ProcessingEnvironment pe = null;

    ProcessingEnvironment t(ProcessingEnvironment pe) {
        pe.getElementUtils().getTypeElement("a");
        return pe;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12058().t(pe);
    }
}
