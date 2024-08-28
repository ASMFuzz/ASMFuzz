import javax.management.*;

public class MyJVMTest_15080 {

    static Boolean done = false;

    static int count = 224227808;

    Boolean postRegister(Boolean done) {
        count++;
        return done;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15080().postRegister(done);
    }
}
