#!/usr/bin/env bash
#
# Author: omitida
# Date: 16/11/2026
# Description: A mini shell script for gradle
#
# global filename
filename=

function helper() {
    echo "Usage: ${0} < -options > <project-name>"
    echo
    echo "Avaliable Options"
    echo "==================="
    echo "-g: generate generic project structure with build.gradle."
    echo "-i  initialized gradle project with prompt to follow."
    echo "-d  Delete specified directory name."
    exit
}

function build_gradle_file() {
    echo "
plugins {
    id 'java'
    id 'application'
}

version = '0.0.1'

java {
    sourceCompatibility=JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.6.0'
    testImplementation 'org.assertj:assertj-core:3.27.3'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.6.0'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher:1.6.0'
}

test {
    useJUnitPlatform()
}

application {
    mainClass = 'com.practice.app.AppMain'
}

jar {
    manifest {
        attributes 'Main-Class': 'com.practice.app.AppMain'
    }
}
    " > build.gradle
}


function write_java_file() {
    filename="${1}"
    echo "package com.practice.app;

public class AppMain {
    public static void main(String[] args) {
        strLen(\"Howdy...\");
    }

    public static int strLen(String str) {
        return str.length();
    }
}
    " > "${filename}"
}

function write_java_test_file() {
    filename="${1}"
    echo "package com.practice.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class AppMainTest {

    @Test
    @DisplayName(\"check string length.\")
    public void str_length_checker() {
        var expectedValue = \"Howdy...\".length();
        var gottenValue = AppMain.strLen(\"Howdy...\");
        assertEquals(gottenValue, expectedValue);
    }
}
    " > "${filename}"
}

[[ "${#}" -ne 2 ]] &&  helper

opstrings="d:g:i:h"
while getopts "${opstrings}" opts; do
    case "${opts}" in
        d)
            directory_name=${OPTARG}
            while read -r -p "Delete ${directory_name} [Y|n]? " ans; do
                case "${ans}" in
                    [Yy])
                      rm -rf "${directory_name}"
                      echo "${directory_name} deleted."
                      break
                    ;;

                    [Nn])
                      echo "${directory_name} NOT deleted."
                      break
                    ;;
                    *) echo "Invalid Option ${ans}. Use only 'y' or 'n'."
                esac
            done
            ;;
        g)
            echo "Generate generic gradle file structure."
            filename="${OPTARG}"
            mkdir "${filename}"
            cd "${filename}" || exit

            # make build.gradle file
            build_gradle_file

            mkdir -p src/main/java/com/practice/app src/test/java/com/practice/app

            # make java file to be comiled
            java_file=src/main/java/com/practice/app/AppMain.java
            java_test_file=src/test/java/com/practice/app/AppMainTest.java
            touch "${java_file}"
            touch "${java_test_file}"

            write_java_file "${java_file}"
            write_java_test_file "${java_test_file}"

            gradle test
            gradle run
            ;;
        i)
            echo "Using gradle init; interraction view."
            filename="${OPTARG}"
            mkdir "${filename}"
            cd "$filename" || exit
            gradle init
            ;;
        h)
            helper;;
        *) echo "Invalid options."
        exit;;
    esac
done
