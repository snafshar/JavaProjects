# Choosing Java Collections

| Need | Typical choice | Trade-off |
|---|---|---|
| Indexed sequence | ArrayList | Fast indexed access; middle insertions shift elements |
| Queue/deque | ArrayDeque | Efficient ends; rejects null |
| Unique values | HashSet | Average constant-time operations; no ordering guarantee |
| Sorted unique values | TreeSet | Logarithmic operations and sorted order |
| Key-value lookup | HashMap | Average constant-time lookup; no ordering guarantee |
| Priority queue | PriorityQueue | Head is least element by default; iterator is not sorted |

Choose based on access patterns and correctness requirements, not familiarity alone.