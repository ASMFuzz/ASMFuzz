import os

detectFeature_path = '/root/asmfuzz/feature/src/test/data/detectFeature'
getFeature_path = '/root/asmfuzz/feature/src/test/data/getFeature'

detectFeature_files = os.listdir(detectFeature_path)
getFeature_files = os.listdir(getFeature_path)

for file in detectFeature_files:
    file_parts = file.split('-')
    if len(file_parts) > 1:
        prefix = file_parts[0]
        suffix = "-".join(file_parts[1:])
        paired_file = prefix + "-" + suffix
        print(suffix)
        if suffix in getFeature_files:
            print(f"Pair found: {file}")
        else:
            print(f"Pair not found: {file}")

# for file in detectFeature_files:
#     if file not in getFeature_files:
#         print(f"File in detectFeature but not in getFeature: {file}")
#
# for file in getFeature_files:
#     if file not in detectFeature_files:
#         print(f"File in getFeature but not in detectFeature: {file}")