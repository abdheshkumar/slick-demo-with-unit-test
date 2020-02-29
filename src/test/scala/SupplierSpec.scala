import abtechsoft.{DAL, Supplier}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.funsuite.AsyncFunSuite
import slick.jdbc.SetParameter.SetUnit
import slick.jdbc.{H2Profile, SQLActionBuilder}

class SupplierSpec extends AsyncFunSuite with ScalaFutures {
  val supplier = new DAL(H2Profile)
  import supplier.profile.api._
  val db = Database.forConfig("h2mem1")

  test("This should insert record") {
    println(supplier.suppliers.insertStatement)
    val insert = db.run(supplier.insert(Supplier(name = "Test-1"),Supplier(name = "Test-1")))
    insert.map(f => assert(f == Some(2)))
  }

  test("This should work") {
    val select = for {
      //_ <- db.run(supplier.insert(Supplier(id = Some(1), "Test-1")))
      data <- db.run(supplier.getAll)
    } yield data
    select.map(f => assert(f == List(Supplier(Some(1), "Acme, Inc."))))
  }

  /*  private def dropTables() = {
      supplier.suppliers.schema.dropStatements.toList.reverse.foreach { query =>
        println(query)
        db.run(SQLActionBuilder(List(query), SetUnit).asUpdate)
      }
    }*/
}
