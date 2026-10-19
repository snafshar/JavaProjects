# TaskTrail — Java 17 Task Tracker

TaskTrail is a small terminal task tracker that stores tasks in a local tab-separated file. It demonstrates a simple domain model, service layer, persistence, input validation, and dependency-free tests.

## Build, test, and run

```bash
cd exercises/2026-10-19/TaskTrail
./run-tests.sh
javac *.java
java TaskTrail add "Review algorithms"
java TaskTrail list
java TaskTrail done 1
java TaskTrail list
```

The source launcher `java TaskTrail.java` is not used because TaskTrail depends on the separate model and service classes; compile the folder first. Generated class files are ignored by Git.

Set `TASKTRAIL_FILE` to choose a different data file. The default is `tasks.tsv` in the current directory. The file format stores a numeric ID, a status, and a Base64-encoded UTF-8 title separated by tabs.

## Commands

- `add "title"`: create a task.
- `list`: list saved tasks.
- `done ID`: mark a task as complete.

This is an educational local utility, not a multi-user database. Avoid sharing the data file between concurrent writers.
