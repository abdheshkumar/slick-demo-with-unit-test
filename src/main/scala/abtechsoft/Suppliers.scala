package abtechsoft

import slick.dbio.Effect
import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape
import slick.sql.FixedSqlAction

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by abdhesh on 24/04/17.
  */
trait DBProfile {
  val profile: JdbcProfile
}
trait Schema {
  this: DBProfile =>
  import profile.api._
  // Definition of the SUPPLIERS table

  private[abtechsoft] class Suppliers(tag: Tag)
      extends Table[Supplier](tag, "suppliers") {
    def id: Rep[Int] =
      column[Int]("id", O.PrimaryKey, O.AutoInc) // This is the primary key column
    def name: Rep[String] = column[String]("name")

    // Every table needs a * projection with the same type as the table's type parameter
    def * : ProvenShape[Supplier] = (id.?, name).mapTo[Supplier]
  }

  val suppliers = TableQuery[Suppliers]
  def insert(s: Supplier*): DBIO[Option[Int]] = {
    (suppliers ++= s) //.map(id => s.copy(id = Some(id)))
  }
  def getAll: DBIO[Seq[Supplier]] = suppliers.result
}

case class Supplier(id: Option[Int] = None, name: String)
