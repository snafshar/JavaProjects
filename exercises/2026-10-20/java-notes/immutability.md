# Immutability in Java

An immutable object does not expose methods that change its observable state after construction.

Common practices:
- Make fields `private final`.
- Validate constructor arguments.
- Avoid setters.
- Copy mutable input collections before storing them.
- Return an unmodifiable view or defensive copy where appropriate.
- Do not assume a final reference makes its referenced object immutable.

Immutability can simplify reasoning and concurrency, but it does not remove the need to validate data or protect mutable objects nested inside a model.
