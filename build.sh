#!/usr/bin/env bash

case $1 in
    #python)
        #version="/usr/bin/env python3"
        #python3 -m zipapp -p $version bin/zipapp/dialogo.pyz
        #;;
    java | *)
        mainsrc="src/java/org/quipa/dialogo/Main.java"
        javac -d bin/java/classes -cp src/java $mainsrc
        
        target=bin/java/jar/dialogo.jar
        jar ufe $target "org.quipa.dialogo.Main" -C bin/java/classes .
        ;;
esac
