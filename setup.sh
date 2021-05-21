#!/usr/bin/env bash

case $1 in
    java | *)
        mainsrc="src/java/org/quipa/dialogo/Dialogo.java"
        javac -d bin/java/classes -cp src/java $mainsrc
        mainclass="org.quipa.dialogo.Dialogo"
        target=bin/java/jar/dialogo.jar
        jar cfe $target $mainclass -C bin/java/classes .
        ;;
esac
