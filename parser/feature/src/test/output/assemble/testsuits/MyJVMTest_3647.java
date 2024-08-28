import java.io.IOException;

public class MyJVMTest_3647 {

    String sayHello() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3647().sayHello());
    }
}
