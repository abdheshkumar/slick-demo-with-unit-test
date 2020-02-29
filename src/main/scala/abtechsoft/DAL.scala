package abtechsoft

import slick.jdbc.JdbcProfile

import scala.concurrent.Future

class DAL(val profile: JdbcProfile, val db: JdbcProfile#Backend#DatabaseDef)
    extends Schema
    with DBProfile {
  import profile.api._
  def insert(s: Supplier*): Future[Option[Int]] = db.run {
    (suppliers ++= s)
  }
  def getAll: Future[Seq[Supplier]] = {
    db.run(suppliers.result)
  }
}
