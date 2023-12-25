# ASMFuzz

## 特征提取
获取文档中的API名称等信息
python3 ./ParseAPI/01get_API_info.py

获取结构信息
python3 ./ParseAPI/02get_constructor_info.py

获取方法信息
python3 ./ParseAPI/03get_method_info.py

## 差分测试
数据库等准备，具体步骤可以解除注释
python3 ./workline/step0_preprocess.py

差分测试
python3 ./workline/step4_harness.py

合成组装
python3 ./workline/step4_mutate_testcase.py

分析筛选
python3 ./workline/step6_analysis_testcases.py