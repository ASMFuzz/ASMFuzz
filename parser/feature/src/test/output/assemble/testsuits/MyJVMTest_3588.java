import javax.xml.soap.MessageFactory;

public class MyJVMTest_3588 {

    MessageFactory factory() throws Throwable {
        try {
            MessageFactory factory = MessageFactory.newInstance();
            System.out.println("     TEST: factory class = [" + factory.getClass().getName() + "]\n");
            return factory;
        } catch (Throwable t) {
            System.out.println("     TEST: Throwable [" + t.getClass().getName() + "] thrown.\n");
            t.printStackTrace();
            throw t;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3588().factory());
    }
}
