package abtechsoft

import slick.jdbc.JdbcProfile

class DAL(val profile: JdbcProfile) extends Schema with DBProfile {
  import profile.api._
  def insert(s: Supplier*): DBIO[Option[Int]] = {
    (suppliers ++= s) //.map(id => s.copy(id = Some(id)))
  }
  def getAll: DBIO[Seq[Supplier]] = suppliers.result
}
