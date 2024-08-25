# Environment Initialization


## Conda Initialization
Create the conda environment directory, you need to download conda in advance.

## step1: make conda environment directory
```bash
cd ~/anaconda/env
mkdir asmfuzz ##[your_conda_name]
```

## step2: Unzip the environment zip

```bash
cd ~/anaconda/env/asmfuzz
sudo tar -xjf asmfuzz-0.0-py31_0.tar.bz2 ##[your_conda_name]
```

OR `conda env create -f asmfuzz.yaml -n asmfuzz`

> asmfuzz-0.0-py31_0.tar.bz2: https://zenodo.org/records/13340493



## step3: Activate ASMFuzz

```
conda env list
conda activate asmfuzz
```

## Database Initialization

```bash
cd /root/asmfuzz/workline/web

python manage.py makemigrations analysis

python manage.py migrate analysis

python manage.py loaddata analysis/fixtures/testbed.json

```
