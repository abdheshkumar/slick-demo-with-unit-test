import abtechsoft.{DAL, Supplier}
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.{BeforeAndAfterAll, FutureOutcome, Outcome}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.flatspec.FixtureAnyFlatSpecLike
import org.scalatest.funsuite.AsyncFunSuiteLike
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Span}
import slick.jdbc.SetParameter.SetUnit
import slick.jdbc.{H2Profile, SQLActionBuilder}

import scala.util.control.Exception._
class SupplierSpec
    extends FixtureAnyFlatSpecLike
    with ScalaFutures
    with Matchers {

  type FixtureParam = DAL
  override def withFixture(test: OneArgTest): Outcome = {
    val db = slick.jdbc.JdbcBackend.Database.forConfig("h2mem1")
    val supplier = new DAL(H2Profile, db)
    try { test(supplier) } finally db.close()

  }
  "This" should "insert record" in { supplier =>
    val insert =
      supplier.insert(Supplier(name = "Test-1"), Supplier(name = "Test-1"))
    whenReady(insert, Timeout(scaled(Span(200, Millis)))) { _ shouldBe Some(2) }
  }

  "Get All supplier" should "work" in { supplier =>
    whenReady(supplier.getAll) {
      _ shouldBe List(Supplier(Some(1), "Acme, Inc."))
    }
  }
}
