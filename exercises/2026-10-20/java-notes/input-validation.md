# Java CLI Input Validation

1. Parse input close to the command boundary.
2. Catch the specific exception expected from parsing.
3. Explain the accepted format in the error message.
4. Reject values outside the documented range.
5. Keep domain logic independent of console input.
6. Test blank strings, whitespace, overflow, malformed values, and valid boundary values.

Avoid catching `Exception` and silently continuing. A clear error should tell the user what to fix without printing a stack trace for ordinary mistakes.
