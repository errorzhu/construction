#!/usr/bin/env bash

root_dir=$(
  cd "$(dirname $0)"
  pwd
)
root_dir=$(readlink -f "$root_dir")
work_dir=$(dirname $root_dir)
cd $work_dir

logdir=$work_dir/logs

nohup java  -DLOG_DIR=$logdir -jar $work_dir/ruoyi-admin.jar --spring.config.location=$work_dir/etc/* --logging.config=$work_dir/etc/logback.xml  > /dev/null 2>&1 &