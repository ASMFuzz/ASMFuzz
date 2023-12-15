from workline.table_to_class.Table_Testcase_Class import Testcase_Object


def harness_testcase(testcase):
    testcase_object = Testcase_Object(testcase)
    # start_time = time.time()
    javac_result = testcase_object.engine_compile_testcase()
    # Obtain the diff result, with output from each engine.
    harness_result = testcase_object.engine_run_testcase()
    # Vote.
    different_result_list = harness_result.differential_test()
    return javac_result, harness_result, different_result_list
