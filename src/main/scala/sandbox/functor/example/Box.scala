package sandbox.functor.example

import sandbox.functor.Codec
import sandbox.typeclass.Printable

final case class Box[A](value: A)

object Box {
  implicit def boxPrintable[A](implicit p: Printable[A]): Printable[Box[A]] =
    p.contramap[Box[A]](_.value)

  implicit def boxCodec[A](implicit c: Codec[A]): Codec[Box[A]] =
    c.imap(value => Box(value), box => box.value)
}