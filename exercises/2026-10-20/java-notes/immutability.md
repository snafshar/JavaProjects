# Immutability in Java

An immutable object does not expose methods that change its observable state after construction.

- Make fields private final.
- Validate constructor arguments.
- Avoid setters.
- Copy mutable input collections before storing them.
- Return an unmodifiable view or defensive copy where appropriate.
- Remember that a final reference does not make the referenced object immutable.

Immutability can simplify reasoning and concurrency, but mutable objects nested inside a model still need protection.