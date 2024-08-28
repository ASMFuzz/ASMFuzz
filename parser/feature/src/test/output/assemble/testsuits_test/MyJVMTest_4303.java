import java.io.FileOutputStream;

public class MyJVMTest_4303 {

    void method2() {
        System.out.println("Source13#method2() : Performing array copy..");
        double counter = 0;
        for (int i = 5; i < 10; i++) {
            counter += Math.random();
            System.arraycopy(new String[] { "1", "2", "3" }, 0, new Object[] { "4", "5", "6" }, 1, 2);
        }
        System.out.println("Done!");
    }

    void method3() {
        try {
            System.out.println("Source13#method3() : Performing Garbage dump");
            FileOutputStream fos = new FileOutputStream("garbage_dump");
            fos.write(new byte[] { 1, 2, 3, 4, 5, 6, 7 });
            fos.flush();
            fos.close();
            System.out.println("Done!");
            method2();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4303().method3();
    }
}
