import java.util.*;

public class MyJVMTest_14161 {

    static Random generator = new Random();

    void hashCodeEqualsTest() throws Exception {
        for (int i = 0; i < 100; i++) {
            UUID u1 = UUID.randomUUID();
            UUID u2 = UUID.fromString(u1.toString());
            if (u1.hashCode() != u2.hashCode())
                throw new Exception("Equal UUIDs with different hashcodes");
        }
        for (int i = 0; i < 1000; i++) {
            long l = generator.nextLong();
            long l2 = generator.nextLong();
            int position = generator.nextInt(64);
            UUID u1 = new UUID(l, l2);
            l = l ^ (1L << position);
            UUID u2 = new UUID(l, l2);
            if (u1.equals(u2))
                throw new Exception("UUIDs with different bits equal");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14161().hashCodeEqualsTest();
    }
}
