#!/usr/bin/env bash

# morphological tests

for f in test/morf/*.dialogo
do
  fname=$(basename $f .dialogo)
  dname=$(dirname $f)
  diff -u <(./run.sh morf $f) "$dname/results/$fname.txt"
done
