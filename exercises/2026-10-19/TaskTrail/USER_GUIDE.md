# TaskTrail User Guide

## Create and manage tasks

```bash
java TaskTrail.java add "Draft a project outline"
java TaskTrail.java add "Review the unit tests"
java TaskTrail.java list
java TaskTrail.java done 1
```

The CLI expects Java 17 or newer because it uses switch expressions and `Path.of`.

## Choose the data file

The application uses `tasks.tsv` in the current working directory unless the `TASKTRAIL_FILE` environment variable points to another path. The saved format uses Base64 for task titles so tabs and newlines cannot corrupt the delimiter structure.

## Error handling

Missing command arguments print usage. Unknown task identifiers and invalid commands exit with an error. A malformed record produces a storage error rather than silently dropping the record.

## Extension ideas

Add a delete command, a due-date field, filters for open tasks, or a JSON export format. Keep the persistence layer separate from command-line parsing.
