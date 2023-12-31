import os
import sys
from pathlib import Path
BASE_DIR = str(Path(__file__).resolve().parent.parent)
sys.path.append(BASE_DIR)
from src.studyMysql.Table_Operation import Table_Testcase
from src.utils.config import generate_model_dir, generate_model_name
from workline.table_to_class.Table_Testcase_Class import Testcase_Object
import tensorflow as tf

tf.get_logger().setLevel('ERROR')
# os.environ['TF_CPP_MIN_LOG_LEVEL'] = '3'  # Mask prompts for TensorFlow
os.environ["TF_CPP_MIN_LOG_LEVEL"] = "1"
# os.environ['CUDA_VISIBLE_DEVICES'] = "2"

import gpt_2_simple as gpt2

sess = gpt2.start_tf_sess()
sess = gpt2.reset_session(sess)

gpt2.load_gpt2(sess,
               model_dir=generate_model_dir,
               model_name=generate_model_name,
               multi_gpu=True)
table_testcase = Table_Testcase()
list_unfuzzing = table_testcase.selectIdFromTableTestcase(11)
print("There are %d test cases in total that need to be mutated." % len(list_unfuzzing))
for unfuzzing_item in list_unfuzzing:
    testcase_object = Testcase_Object(unfuzzing_item)
    testcase_object.Mutation_times += 1
    table_testcase.updateMutationTimes(testcase_object.Mutation_times, testcase_object.Id)

    print('*' * 25 + f'mutation testcase{testcase_object.Id}' + '*' * 25)

    testcase_mutation_method1, testcase_mutation_method2 = testcase_object.mutation_method1_2(sess, False)

    testcase_mutation_method4 = testcase_object.mutation_method4()

    all_len = len(testcase_mutation_method1) + len(testcase_mutation_method2) + len(testcase_mutation_method4)

    print(
        f'A total of {len(testcase_mutation_method1)} GPT continuation test cases, {len(testcase_mutation_method2)} GPT replacement test cases, {len(testcase_mutation_method4)} operator replacement test cases were generated, a total of {all_len} test cases, and they have been stored in the database.')
