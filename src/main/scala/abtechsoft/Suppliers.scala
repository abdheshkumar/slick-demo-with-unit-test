package abtechsoft

import slick.jdbc.JdbcProfile
import slick.lifted.ProvenShape

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
}

case class Supplier(id: Option[Int] = None, name: String)
