import java.lang.annotation.*;

public class MyJVMTest_17501 {

    String meh() {
        return "meh";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17501().meh());
    }
}
