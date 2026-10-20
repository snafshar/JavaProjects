# Java Exception Handling

Use exceptions for exceptional or invalid conditions, not as ordinary loop control.

- Validate arguments at public API boundaries.
- Throw an exception that communicates the violated contract.
- Preserve the original cause when wrapping lower-level errors.
- Add context without exposing secrets.
- Close resources with try-with-resources.
- Do not swallow exceptions or log and rethrow without adding useful context.

Document which failures callers should handle. A CLI can convert expected domain errors into a concise message and non-zero exit status.
