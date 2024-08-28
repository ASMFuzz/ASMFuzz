import java.util.concurrent.atomic.*;

public class MyJVMTest_2799 {

    static Test8007722 new_obj = null;

    static int i = 4;

    static AtomicReference<Test8007722> ref = null;

    int test(Test8007722 new_obj) {
        Test8007722 o = ref.getAndSet(new_obj);
        int ret = o.i;
        o.i = 5;
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2799().test(new_obj));
    }
}
