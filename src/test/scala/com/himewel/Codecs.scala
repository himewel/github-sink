import cats._
import com.himewel.models._
import Implicits._
import io.circe.{ Decoder, Encoder }
import io.circe.testing.CodecTests
import org.scalacheck.Arbitrary
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.Configuration
import org.typelevel.discipline.scalatest.FunSuiteDiscipline


trait CodecSpec extends AnyFunSuite with Configuration with FunSuiteDiscipline {
  def testAll[A](name: String)(implicit evD: Decoder[A], evE: Encoder[A], arbA: Arbitrary[A], eqA: Eq[A]): Unit = {
    checkAll(s"CodecTests[${name}].unserializableCodec", CodecTests[A].unserializableCodec)
    checkAll(s"CodecTests[${name}].codec", CodecTests[A].codec)
  }
}

class UserSpec extends CodecSpec {
  testAll[User]("User")
}

class RepoSpec extends CodecSpec {
  testAll[Repo]("Repo")
}