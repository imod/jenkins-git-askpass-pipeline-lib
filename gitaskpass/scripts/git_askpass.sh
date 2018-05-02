#!/bin/sh
case "$1" in
Username*) echo $USERNAME ;;
Password*) echo $PASSWORD ;;
esac
