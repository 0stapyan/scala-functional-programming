package kse.model

// Small helper used by the generator specifications to signal an impossible branch.
case class DummyError(message: String) extends RuntimeException(message)
