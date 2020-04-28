#!/bin/bash

#variables
name_project=$1
name_classMain=$2

if [ $name_project ] && [ $name_classMain ]; then
    #estructura principal
    mkdir $name_project
    cd $name_project
    mkdir src
    mkdir bin

    #compilador
    touch compilador.sh
    plantilla="cd src/\njavac -d ../bin/ modelo/*.java\njavac -d ../bin/ vista/*.java\njavac -d ../bin/ controlador/*.java"
    echo $plantilla > compilador.sh

    #directorio modelo
    cd src
    mkdir modelo
    cd modelo
    touch $name_classMain".java"
    plantilla="package modelo;\npublic class "$name_classMain"{\n}"
    echo $plantilla > $name_classMain".java"

    #directorio vista
    cd ..
    mkdir vista
    cd vista
    touch Lienzo.java
    touch Main.java
    imports="import java.awt.Graphics;\nimport javax.swing.JPanel;"
    body="\t@Override\n\tpublic void paint(Graphics g) {\n\t\tsuper.paint(g);\n\t}"
    plantilla="package vista;\n\n"$imports"\n\npublic class Lienzo extends JPanel {\n"$body"\n}"
    echo $plantilla > Lienzo.java
    imports="import javax.swing.JFrame;"
    body="\t\tJFrame ventana = new JFrame(\"Vista\");\n\t\tLienzo lienzo = new Lienzo();\n\t\tventana.add(lienzo);\n\t\tventana.setSize(300, 300);\n\t\tventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t\tventana.setVisible(true);"
    plantilla="package vista;\n\n"$imports"\n\npublic class Main {\n\tpublic static void main (String[] args) {\n"$body"\n\t}\n}"
    echo $plantilla > Main.java

    #directorio controlador
    cd ..
    mkdir controlador
    cd controlador
    touch Controlador.java
    imports="import "modelo.$name_classMain";\nimport vista.Lienzo;"
    plantilla="package controlador;\n\n"$imports"\n\npublic class Controlador {\n}"
    echo $plantilla > Controlador.java
else
    echo "Falta el nombre del proyecto y/o clase principal del modelo"
fi