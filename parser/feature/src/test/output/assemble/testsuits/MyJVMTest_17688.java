import java.security.MessageDigest;

public class MyJVMTest_17688 {

    static MessageDigest messageDigest = null;

    boolean isClonable(final MessageDigest messageDigest) {
        try {
            messageDigest.clone();
            return true;
        } catch (final CloneNotSupportedException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17688().isClonable(messageDigest));
    }
}
