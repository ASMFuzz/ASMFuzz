import javax.management.*;

public class MyJVMTest_5644 {

    static Boolean done = false;

    static int count = 2;

    Boolean postRegister(Boolean done) {
        count++;
        return done;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5644().postRegister(done);
    }
}
