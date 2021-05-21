#!/usr/bin/env bash

case $1 in
    java | *)
        mainsrc="src/java/org/quipa/dialogo/Dialogo.java"
        javac -d bin/java/classes -cp src/java $mainsrc
        
        target=bin/java/jar/dialogo.jar
        mainclass="org.quipa.dialogo.Dialogo"
        jar ufe $target $mainclass -C bin/java/classes .
        ;;
esac
