import java.util.ArrayList;

public class MyJVMTest_11368 {

    void m() {
        new ArrayList<>();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11368().m();
    }
}
