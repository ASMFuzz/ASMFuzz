import javax.management.*;

public class MyJVMTest_3514 {

    Boolean isThingy() {
        return Boolean.TRUE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3514().isThingy());
    }
}
