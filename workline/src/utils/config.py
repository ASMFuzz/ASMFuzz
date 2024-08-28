import argparse
import json
import os
import pathlib
import sys
from pathlib import Path

BASE_DIR = str(Path(__file__).resolve().parent.parent.parent)
sys.path.append(BASE_DIR)
generate_model_dir = os.path.join(BASE_DIR, 'model')
generate_model_name = 'nisl_model'
