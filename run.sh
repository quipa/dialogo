#!/usr/bin/env bash

case $1 in
    java | *)
        rlwrap java -jar bin/java/jar/dialogo.jar "$@"
        ;;
esac
