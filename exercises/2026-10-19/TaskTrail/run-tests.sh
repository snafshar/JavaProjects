#!/usr/bin/env sh
set -eu
cd "$(dirname "$0")"
BUILD_DIR="$(mktemp -d)"
trap 'rm -rf "$BUILD_DIR"' EXIT HUP INT TERM
javac -Xlint:all -d "$BUILD_DIR" TaskStatus.java Task.java TaskStore.java TaskService.java TaskTrail.java TaskStoreTest.java TaskServiceTest.java
java -ea -cp "$BUILD_DIR" TaskStoreTest
java -ea -cp "$BUILD_DIR" TaskServiceTest
echo "TaskTrail checks passed."
