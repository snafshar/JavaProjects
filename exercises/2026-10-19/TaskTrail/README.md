# TaskTrail — Java 17 Task Tracker

TaskTrail is a small terminal task tracker that stores tasks in a local tab-separated file. It demonstrates a simple domain model, service layer, persistence, input validation, and dependency-free tests.

## Build and run

```bash
cd exercises/2026-10-19/TaskTrail
./run-tests.sh
java TaskTrail.java add "Review algorithms"
java TaskTrail.java list
java TaskTrail.java done 1
java TaskTrail.java list
```

Set `TASKTRAIL_FILE` to choose a different data file. The default is `tasks.tsv` in the current directory. The file format stores a numeric ID, a status, and a Base64-encoded UTF-8 title separated by tabs.

## Commands

- `add "title"`: create a task.
- `list`: list saved tasks.
- `done ID`: mark a task as complete.

This is an educational local utility, not a multi-user database. Avoid sharing the data file between concurrent writers.
