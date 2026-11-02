# Functional Programming in Scala

Solutions to the challenge exercises of a functional programming course at Kyiv School of Economics, in Scala 3. The course gave a template file for each unit with type signatures and `???` holes; the work here is filling those holes — building numbers, booleans, sets and a small effect type from first principles, with no use of the standard library's versions.

Each unit builds on the previous ones, moving from basic recursion to type classes and monadic composition.

| Unit | Topic | What is implemented |
| --- | --- | --- |
| 1 | Peano arithmetic | Addition, multiplication and power on `Long` using only increment/decrement, all tail-recursive |
| 2 | Boolean algebra | `Boolean` as a union type `True \| False`; the connectives and a fold over lists, built from pattern matching |
| 3 | Boolean expression trees | An expression AST with `evaluate` (symbolic simplification) and `substitute` |
| 4 | Natural numbers | `Numeral` as `Zero` / `Successor`, with ordering, addition and subtraction |
| 5 | Sets of numerals | A binary-search-tree set with union and intersection |
| 6 | Generic ordered sets | `Set[A]` parameterised over an `Order` type class, with union, intersection, difference and symmetric difference |
| 7 | A `Try` effect | A `Try` monad (`map`/`flatMap`) and data aggregation with for-comprehensions |

> The template files (signatures, class layout, the course's test specifications) were provided by the course. The implementations in `src/main` are mine. Unit 7 is included for completeness; the course did not provide a template or tests for it.

## Highlights

**Unit 1 — everything from increment.** Addition counts up from the left operand while counting the right down to zero; multiplication is repeated addition; power is repeated multiplication. All three are tail-recursive, so they run in constant stack space.

**Unit 3 — a tiny theorem simplifier.** `evaluate` reduces an expression symbolically: `True ∧ x` becomes `x`, implication is rewritten as `¬a ∨ b`, and equivalence reduces to two implications. Variables stay as variables, so a partially-known expression simplifies as far as it can.

**Unit 6 — sets over a type class.** The set is generic in its element type and takes an `Order[A]` instance, so the same tree works for any orderable type. Union, intersection, difference and symmetric difference are defined recursively over the tree.

**Unit 7 — composing fallible calls.** A `Try` enum with `map` and `flatMap` lets a chain of API calls be written as a for-comprehension that short-circuits on the first failure, shown both in sugared and desugared form.

## Tests

The course's exercises come with [ScalaCheck](https://scalacheck.org/) property-based specifications (in `src/test`), which check algebraic laws rather than single cases — for example that set union is commutative and associative, that Peano addition matches integer addition, and that boolean axioms hold for all inputs. They are included here and run with:

```bash
sbt test
```

Units 1–6 have specifications. One course-provided support file for Unit 6 (`kse.unit6.algebra`, a small `Monoid` type class used by the generators) was not available, so a minimal version is reconstructed in `src/main/scala/kse/unit6/algebra.scala` and marked as such in a comment; it is not part of the graded work.

## Requirements

- JDK 17 or newer
- [sbt](https://www.scala-sbt.org/) (it downloads Scala 3.5.2 on first run)

## License

[MIT](LICENSE)
