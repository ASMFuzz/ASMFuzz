import javax.management.*;

public class MyJVMTest_12848 {

    Boolean isThingy() {
        return Boolean.TRUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12848().isThingy());
    }
}
