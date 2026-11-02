package kse.unit6

import kse.unit4.challenge.numerals.{Numeral, Zero}

// NOTE: this file reconstructs the `kse.unit6.algebra` package that the Unit 6
// tests import. The original was provided by the course and is not part of the
// student's work; it is recreated here only so the project compiles and the
// Unit 6 specifications can run. It defines a Monoid type class and the Numeral
// instance the generators use to build strictly ordered sets.
object algebra:

  trait Monoid[T]:
    def unit: T
    extension (left: T) infix def +(right: T): T

  object Monoid:
    def apply[T](using m: Monoid[T]): Monoid[T] = m

  given Monoid[Numeral] with
    def unit: Numeral = Zero
    extension (left: Numeral) infix def +(right: Numeral): Numeral = left + right
