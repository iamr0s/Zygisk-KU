#!/usr/bin/python3
# -*- coding:utf-8 -*-

import os
import sys
import zipfile

input_path = sys.argv[1]
output_path = sys.argv[2]


def get_all_files(dir: str, path: str = ''):
    if os.path.isfile(dir + path):
        return [path]
    files = []
    for file in os.listdir(dir + path):
        files += get_all_files(dir, path + '/' + file)
    return files


zip = zipfile.ZipFile(output_path, 'w', zipfile.ZIP_DEFLATED)

for file in get_all_files(input_path):
    zip.write(input_path + '/' + file, file)

zip.close()
