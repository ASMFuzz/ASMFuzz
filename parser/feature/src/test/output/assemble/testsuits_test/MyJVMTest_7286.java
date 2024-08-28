import javax.management.*;

public class MyJVMTest_7286 {

    short getB() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7286().getB());
    }
}
