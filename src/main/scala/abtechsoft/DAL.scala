package abtechsoft

import slick.jdbc.JdbcProfile

class DAL(val profile: JdbcProfile) extends Schema with DBProfile {}
