# Java numerical input checks

For numeric utilities:

- Reject invalid durations and impossible counts early.
- Decide whether `NaN` and infinite values are valid for the domain.
- Use `double` for rates and percentages when integer division would lose precision.
- Avoid returning ambiguous sentinel values for invalid inputs.
- Keep exceptions and method documentation consistent.
- Test zero, negative, boundary, and very large values.