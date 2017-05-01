package catstut

import cats.Functor
import scala.language.higherKinds

object ApplicativeMain extends App {


  trait Applicative[F[_]] extends Functor[F] {
    def product[A, B](fa: F[A], fb: F[B]): F[(A, B)]

    def pure[A](a: A): F[A]
  }

  implicit class Ops[L](x:  Either[L, _])(implicit applicative: Applicative[Either[L, ?]]) {
    def product(y: Either[L, _]) = applicative.product(x, y)
  }

  // Example implementation for right-biased Either
  implicit def applicativeForEither[L]: Applicative[Either[L, ?]] = new Applicative[Either[L, ?]] {
    override def product[A, B](fa: Either[L, A], fb: Either[L, B]): Either[L, (A, B)] = (fa, fb) match {
      case (Right(a), Right(b)) => Right((a, b))
      case (Left(l) , _       ) => Left(l)
      case (_       , Left(l) ) => Left(l)
    }

    override def pure[A](a: A): Either[L, A] = Right(a)

    override def map[A, B](fa: Either[L, A])(f: A => B): Either[L, B] = fa match {
      case Right(a) => Right(f(a))
      case Left(l)  => Left(l)
    }
  }



  val s:Either[String, Int] = Right(1);
  val s1:Either[String, Int] = Left("2");

  println(s product s1)

}
