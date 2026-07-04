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
    echo "j:    open and run jshell for java."
}

filename=

JAVA_PLAIN_FILE="
package com.practice.<packagename_place_holder>;

public class <classname_place_holder> {

    public static void main(String[] args) {
        System.out.println(\"Start Here\");
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

option_string="c:d:g:o:r:j:h"
while getopts "${option_string}" opt; do
case "${opt}" in
    c)
        ;;
    d)
        echo "Deleting java file.."
        filename="${OPTARG}"
        while read -p -r "Are you sure you want to delete ${filename}? (y/n) " ans; do
            case "${ans}" in
                [Yy])
                   [[ -f "${filename}" ]] && rm -f "${filename}"
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
    g);;
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
        java -cp . "com/practice/${file,,}/${file^}"
        ;;
    r)
        echo "Running a java program.."
        filename="${OPTARG}"
        check_ext "${filename}"
        file="${filename%.*}"
        javac -d . "${filename}"  # compiles
        java -cp . "com/practice/${file,,}/${file^}" # runs the program
        ;;
    j) echo "Launching jshell for java...."
        jshell
        ;;
    h)
        usage
        ;;
    *);;
esac
done
