import java.beans.BeanDescriptor;

public class MyJVMTest_12285 {

    BeanDescriptor getBeanDescriptor() {
        return new BeanDescriptor(ThirdBeanBeanInfo.class);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12285().getBeanDescriptor());
    }
}
