public class MyJVMTest_14880 {

    static Test6663854_Class_0 arg_0 = null;

    static short var_94 = (short) 'H';

    static Test6663854_Interface_1 var_96 = null;

    Test6663854_Class_0 func_0(Test6663854_Class_0 arg_0) {
        if (!Test6663854_Class_3.var_24) {
            Test6663854_Class_7.var_88 ^= (Test6663854_Class_0.var_4 = Test6663854_Class_3.var_23) << ~Test6663854_Class_0.var_2;
        } else {
            (Test6663854_Class_6.var_82 = (Test6663854_Class_7.var_67 = (Test6663854_Class_3) (new Test6663854_Interface_1[Test6663854_Class_3.var_23][Test6663854_Class_3.var_23])[Test6663854_Class_3.var_23][Test6663854_Class_3.var_23])).var_22 = (((new Test6663854_Class_3[Test6663854_Class_3.var_23][Test6663854_Class_3.var_23])[Test6663854_Class_3.var_23][Test6663854_Class_3.var_23]).var_22 = (arg_0 = arg_0));
        }
        if ((Test6663854_Class_0.var_4 = (Test6663854_Class_0.var_4 = (Test6663854_Class_0.var_4 = Test6663854_Class_3.var_23))) < Test6663854_Class_3.var_21) {
            Test6663854_Class_3.var_24 ^= (Test6663854_Class_3.var_24 ^= (arg_0.var_6 ^ Test6663854_Class_7.var_88++) != (long) "y".codePointAt((int) var_94)) | false;
        } else {
            ++Test6663854_Class_7.var_88;
        }
        var_94 >>= (Test6663854_Class_0.var_4 = Test6663854_Class_3.var_23);
        {
            Test6663854_Class_7.var_66 = (Test6663854_Class_6) (var_96 = new Test6663854_Class_3());
        }
        arg_0.var_8 = 'u';
        var_94 ^= arg_0.var_8;
        ++var_94;
        Test6663854_Class_7.var_88++;
        var_94 += (Test6663854_Class_3.var_20 = '^');
        return arg_0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14880().func_0(arg_0));
    }
}
