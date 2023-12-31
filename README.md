# ASMFuzz
## Feature Extraction

Retrieve API names and other information from the document. `python3 ./ParseAPI/01get_API_info.py`

Retrieve structural information. `python3 ./ParseAPI/02get_constructor_info.py`

Retrieve method information. `python3 ./ParseAPI/03get_method_info.py`

## Differential Testing

Prepare the database and other necessary steps (uncomment the specific steps). `python3 ./workline/step0_preprocess.py`

Perform differential testing. `python3 ./workline/step4_harness.py`

Synthesize and assemble. `python3 ./workline/step4_mutate_testcase.py`

Analyze and filter. `python3 ./workline/step6_analysis_testcases.py`