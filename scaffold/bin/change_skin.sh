#!/usr/bin/env bash


# 获取输入参数个数
numArgs=$#

# 如果参数个数为0，则打印"hello"并退出
if [ $numArgs -eq 0 ]
then
    echo "usage: bash change_skin.sh <groupId> <artifactId> <version>"
    exit 0
fi

root_dir=$(
  cd "$(dirname $0)"
  pwd
)
root_dir=$(readlink -f "$root_dir")
work_dir=$(dirname $root_dir)
cd $work_dir

# 获取输入参数
groupId=$1
artifactId=$2
version=$3

# 遍历当前目录下的文件
find "$work_dir" -type f ! -name "$0" -exec sed -i "s/org\.scaffold/$groupId/g; s/scaffold/$artifactId/g; s/3\.8\.6/$version/g" {} \;

# 遍历固定目录下的一级目录
for dir in "$work_dir"/*/
do
    # 获取目录名称
    dirname=${dir%*/}
    dirname=${dirname##*/}

    # 替换目录名称中的"scaffold"为"artifactId"
    newdir=${dirname//scaffold/$artifactId}

    # 重命名目录
    if [ "$dirname" != "$newdir" ]
    then
        mv "$dir" "$work_dir/$newdir"
    fi
done