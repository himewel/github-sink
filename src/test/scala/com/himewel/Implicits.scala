import cats.Eq
import com.himewel.models._
import io.circe.testing.ArbitraryInstances
import java.time.{ LocalDateTime, ZoneOffset }
import org.scalacheck.{ Arbitrary, Gen }

object Implicits extends ArbitraryInstances {
  val datetimeGen: Gen[LocalDateTime] = for {
    year <- Gen.choose(1970, 2100)
    month <- Gen.choose(1, 12)
    day <- Gen.choose(1, 28)
    hour <- Gen.choose(0, 23)
    minute <- Gen.choose(0, 59)
    second <- Gen.choose(0, 59)
  } yield LocalDateTime.of(year, month, day, hour, minute, second)

  val userGen: Gen[User] = for {
    s <- Gen.alphaStr
    i <- Gen.choose(0, 1000)
    b <- Gen.oneOf(true, false)
    d <- datetimeGen
    so <- Gen.option(Gen.alphaStr)
    io <- Gen.option(Gen.choose(0, 1000))
    bo <- Gen.option(Gen.oneOf(true, false))
    dateOp <- Gen.option(datetimeGen)
  } yield User(s, i, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, b, so, so, so, so, so, bo, so, so, io, io, io, io, dateOp, dateOp)

  val repoGen: Gen[Repo] = for {
    s <- Gen.alphaStr
    i <- Gen.choose(0, 1000)
    b <- Gen.oneOf(true, false)
    d <- datetimeGen
    so <- Gen.option(Gen.alphaStr)
    user <- userGen
    l <- Gen.listOf(Gen.alphaStr)
  } yield Repo(i, s, s, s, b, user, s, so, b, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, s, d, d, d, s, s, s, s, s, i, i, i, so, b, b, b, b, b, b, i, so, b, b, i, so, b, b, b, l, s, i, i, i, s, so, i, i)
  
  implicit val eqUser: Eq[User] = Eq.fromUniversalEquals
  implicit val eqRepo: Eq[Repo] = Eq.fromUniversalEquals
  implicit val arbUser: Arbitrary[User] = Arbitrary(userGen)
  implicit val arbRepo: Arbitrary[Repo] = Arbitrary(repoGen)
}