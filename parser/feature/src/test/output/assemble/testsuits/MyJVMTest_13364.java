import javax.annotation.processing.*;
import javax.lang.model.element.*;
import static javax.tools.Diagnostic.Kind.*;

public class MyJVMTest_13364 {

    static ProcessingEnvironment processingEnv = null;

    static Messager messager = null;

    ProcessingEnvironment init(ProcessingEnvironment processingEnv) {
        this.messager = processingEnv.getMessager();
        return processingEnv;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13364().init(processingEnv);
    }
}
