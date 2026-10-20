# Choosing Java Collections

| Need | Typical choice | Key trade-off |
|---|---|---|
| Indexed sequence | `ArrayList` | Fast indexed access; middle insertions shift elements |
| Queue / deque | `ArrayDeque` | Efficient ends; no null elements |
| Unique values | `HashSet` | Average constant-time operations; no ordering guarantee |
| Sorted unique values | `TreeSet` | Logarithmic operations and sorted order |
| Key-value lookup | `HashMap` | Average constant-time lookup; no ordering guarantee |
| FIFO priority | `PriorityQueue` | Head is least element by default; not a sorted iterator |

Choose based on access patterns and correctness requirements, not familiarity alone.
