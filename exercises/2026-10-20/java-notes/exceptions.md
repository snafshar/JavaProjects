# Java Exception Handling

Use exceptions for exceptional or invalid conditions, not ordinary loop control. Validate arguments at public API boundaries, preserve causes when wrapping lower-level errors, and add context without exposing secrets. Close resources with try-with-resources. Do not swallow exceptions or log and rethrow without useful context.

Document which failures callers should handle. A CLI can turn expected domain errors into concise messages and non-zero exit status.