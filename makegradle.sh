#!/usr/bin/env bash
#
# Author: omitida
# Date: 16/11/2026
# Description: A mini shell script for gradle
#

function helper() {
    echo "Usage: ${0} < -options > <project-name>"
    echo
    echo "Avaliable Options"
    echo "==================="
    echo "-g: generate generic project structure with build.gradle."
    echo "-i  initialized gradle project with prompt to follow."
}

[[ "${#}" -ne 2 ]] &&  helper; exit
