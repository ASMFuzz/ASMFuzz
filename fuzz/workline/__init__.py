import os, sys, json

from pathlib import Path
current_file_path = Path(__file__).resolve()
sys.path.append(str(current_file_path.parent.parent))
from src.studyMysql.Table_Operation import Table_Testcase, Table_Result, Table_Suspicious_Result, Table_Testbed, \
    DataBaseHandle