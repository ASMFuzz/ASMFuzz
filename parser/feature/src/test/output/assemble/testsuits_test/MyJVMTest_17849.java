import java.io.*;

public class MyJVMTest_17849 {

    static ObjectOutput out = null;

    ObjectOutput write(ObjectOutput out) throws IOException {
        IVariableAssignmentTarget res2 = () -> "bar";
        IVariableAssignmentTarget res1 = () -> "fu";
        out.writeObject(res1);
        out.writeObject(res2);
        return out;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17849().write(out);
    }
}
