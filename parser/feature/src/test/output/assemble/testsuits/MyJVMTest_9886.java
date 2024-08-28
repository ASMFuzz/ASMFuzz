import java.lang.annotation.*;

public class MyJVMTest_9886 {

    void inner() {
        class LUnannotated<K> {
        }
        class LExtendsBound<K extends @ClassParamA String> {
        }
        class LExtendsGeneric<K extends @ClassParamA LUnannotated<@ClassParamB String>> {
        }
        class LTwoBounds<K extends @ClassParamA String, V extends @ClassParamB String> {
        }
        class LComplex1<K extends @ClassParamA String & Runnable> {
        }
        class LComplex2<K extends String & @ClassParamB Runnable> {
        }
        class LComplexBoth<K extends @ClassParamA String & @ClassParamA Runnable> {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9886().inner();
    }
}
