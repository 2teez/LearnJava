#!/usr/bin/env bash
#
# Date: 21/06/26
# Description: To crate java stanalones and
#              projects in java programming language.
# Author: omitida - Code-Cratsfman
#
#
function usage() {
    echo "Usage: ${0} -<option> <filename>";
    echo ""
    echo "Options Available"
    echo "-----------------"
    echo ""
    echo "c:    Compile a java project or standalone program file."
    echo "d:    Delete specified file or project file."
    echo "g:    Create a java generic project."
    echo "h:    Display this helper/usage function."
    echo "o:    Create a standalone java program file."
    echo "r:    Run a compiled java project or standalone program file."
    echo "s:    open and run jshell for java."
    echo "j:    Create a jar file from a compiled java project or standalone program file."
    echo "x:    Create, compile, and run a javafx program"
    echo ""
}

filename=


# debug function
function debug() {
    echo "debug: ${*}"; exit;
}

JAVA_PLAIN_FILE="package com.practice.<packagename_place_holder>;

public class <classname_place_holder> {

    public static void main(String[] args) {
        System.out.println(\"Start Here\");
    }
}
"

JAVA_FX_FILE="package com.practice.<packagename_place_holder>FX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class <classname_place_holder>FX extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle(\"JavaFX\");
        stage.setScene(new Scene(new Label(\"Hello JavaFX!\"), 300, 200));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
"

function check_ext(){
    file="${1}"
    filename="${file%.*}"
    extname="${file##*.}"
    [[ "${filename}" = "${extname}" ]] && file="${file}.java"
    filename="${file}"
}

# gateway code to check how many arguments were
# provided on the cli
[[ "$#" -lt 2 ]] && { usage; exit 1; }

option_string="c:d:g:o:r:j:s:x:h"
while getopts "${option_string}" opt; do
case "${opt}" in
    c)
        echo "Compiling a java program.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        javac -d . "${filename}"  # compiles
        ;;
    d)
        echo "Deleting java file.."
        filename="${OPTARG}"
        ! [[ -e "${filename}" ]] && { echo "${filename} file or directory does not exist."; exit 1; }
        while read -r -p "Are you sure you want to delete ${filename}? (y/n) " ans; do
            case "${ans}" in
                [Yy])
                   if [[ -f "${filename}" ]]; then
                       rm -f "${filename}" # remove file
                       # search for the file in the directory com/practice
                       # and delete the directory with the name of the package
                       dirname_to_delete=$(basename "${filename%.*}")
                       find com/practice -type d -name "${dirname_to_delete,}" -exec rm -rf {} \;
                   fi
                   [[ -d "${filename}" ]] && rm -rf "${filename}"
                   echo "Deleted ${filename}."
                    break;;
                [Nn])
                    echo "Cancelled deletion of ${filename}."
                    break;;
                *) echo "Invalid input. Please enter 'y' or 'n'.";;
            esac
        done
        ;;
    g)
        echo "Generating standalone java file.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        echo "${JAVA_PLAIN_FILE}" > "${filename^}"
        perl -pe "s|<packagename_place_holder>|${file,,}|;
                  s|<classname_place_holder>|${file^}|" "${filename^}" > "${filename}_tmp"
        mv "${filename}_tmp" "${filename^}"  # move the temporary file to the original filename

        # make a directory with the package structure to move java file into
        java_project_path="${file^}/com/practice/${file,,}"
        mkdir -p "${java_project_path}"  # create the directory if it doesn't exist
        filename="${filename^}"
        mv "${filename}" "${java_project_path}/"  # move the java file into the directory

        cd "${file^}" || exit
        javac -d out "com/practice/${file,,}/${filename}"
        java -cp out "com.practice.${file,,}.${file^}"
        ;;
    o)
        echo "Generating standalone java file.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        echo "${JAVA_PLAIN_FILE}" > "${filename^}"
        perl -pe "s|<packagename_place_holder>|${file,,}|;
                  s|<classname_place_holder>|${file^}|" "${filename^}" > "${filename}_tmp"
        mv "${filename}_tmp" "${filename^}"
        javac -d . "${filename}"
        java -cp . "com.practice.${file,,}.${file^}"
        ;;
    r)
        echo "Running a java program.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        javac -d . "${filename}"  # compiles
        java -cp . "com/practice/${file,,}/${file^}" # runs the program
        ;;
    s) echo "Launching jshell for java...."
        jshell
        ;;
    j)
        echo "Creating a jar file.."
        # make a manifest file
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        javac -d . *.java
        echo "Main-Class: com.practice.${file,,}.${file^}" > manifest.txt
        echo "" >> manifest.txt
        jar cvfm "${file}.jar" manifest.txt com
        java -jar "${file}.jar"
        ;;
    x)
        echo "Creating, compiling, and running a javafx program.."
        filename="${OPTARG^}"
        check_ext "${filename}"
        file="${filename%.*}"

        echo "${JAVA_FX_FILE}" > "${file}.java"

        perl -pe "s|<packagename_place_holder>|${file,,}|;
                  s|<classname_place_holder>|${file}|" "${filename}" > "${filename}_tmp"

        mv "${filename}_tmp" "${filename%.*}FX.java"; rm "${file}.java"
        file="${filename%.*}FX.java"

        javac -d . \
        --module-path "${JAVAFX_HOME}" \
        --add-modules javafx.controls \
        "${file}"

        file="${file%.*}"

        java -cp . \
        --enable-native-access=javafx.graphics \
        --module-path "${JAVAFX_HOME}" \
        --add-modules javafx.controls \
        "com.practice.${file,}.${file^}"
        ;;
    h)
        usage
        ;;
    *);;
esac
done
