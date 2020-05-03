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

    constructs="\tpublic "$name_classMain"() {}"
    plantilla="package modelo;\n\npublic class "$name_classMain" {\n"$constructs"\n}"
    echo $plantilla > $name_classMain".java"

    #directorio vista
    cd ..
    mkdir vista
    cd vista
    touch Lienzo.java
    touch Main.java

    imports="import java.awt.Graphics;\nimport javax.swing.JPanel;\nimport modelo."$name_classMain";\nimport controlador.Controlador;"
    variables="\t"$name_classMain" modelo;\n\tControlador controlador;"
    methods="\tpublic void actualizar("$name_classMain" _modelo) {\n\t\tmodelo = _modelo;\n\t\trepaint();\n\t}\n\n\t@Override\n\tpublic void paint(Graphics g) {\n\t\tsuper.paint(g);\n\t\tif (modelo != null) {}\n\t}\n\n\tpublic void setControlador(Controlador _controlador) {\n\t\tcontrolador = _controlador;\n\t}"
    body=$variables"\n\n"$methods
    plantilla="package vista;\n\n"$imports"\n\npublic class Lienzo extends JPanel {\n"$body"\n}"

    echo $plantilla > Lienzo.java

    imports="import javax.swing.JFrame;\nimport modelo."$name_classMain";\nimport controlador.Controlador;"
    modelo="\t\t"$name_classMain" modelo = new "$name_classMain"();"
    vista="\t\tLienzo vista = new Lienzo();"
    controlador="\t\tControlador controlador = new Controlador(modelo, vista);\n\t\tcontrolador.configurar();"
    mvc=$modelo"\n"$vista"\n"$controlador
    body=$mvc"\n\t\tJFrame ventana = new JFrame(\"Vista\");\n\t\tventana.add(vista);\n\t\tventana.setSize(600, 600);\n\t\tventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);\n\t\tventana.setVisible(true);"
    plantilla="package vista;\n\n"$imports"\n\npublic class Main {\n\tpublic static void main (String[] args) {\n"$body"\n\t}\n}"

    echo $plantilla > Main.java

    #directorio controlador
    cd ..
    mkdir controlador
    cd controlador
    touch Controlador.java

    imports="import modelo."$name_classMain";\nimport vista.Lienzo;"
    variables="\t"$name_classMain" modelo;\n\tLienzo vista;"
    contructs="\tpublic Controlador("$name_classMain" _modelo, Lienzo _vista) {\n\t\tmodelo = _modelo;\n\t\tvista = _vista;\n\t}"
    methods="\tpublic void notificar() {\n\t\tvista.actualizar(modelo);\n\t}\n\n\tpublic void configurar() {\n\t\tvista.setControlador(this);\n\t}"
    body=$variables"\n\n"$contructs"\n\n"$methods
    plantilla="package controlador;\n\n"$imports"\n\npublic class Controlador {\n"$body"\n}"

    echo $plantilla > Controlador.java
else
    echo "Falta el nombre del proyecto y/o clase principal del modelo"
fi