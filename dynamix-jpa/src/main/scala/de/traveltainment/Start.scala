package de.traveltainment

import de.traveltainment.em.DB
import de.traveltainment.model.Country

/**
 * Created by sergey on 5/25/14.
 */
object Start extends App{

  println("Hello, Scala-JPA!")
  println("check the db " + DB.createNativeQuery("select * from checkTable"))

  val country1 = Country("Moldova", "Chisinau")
  val country2 = Country("Ukraine", "Kiev")
  val country3 = Country("Germany", "Berlin")

  DB.persist(country1)
  DB.persist(country2)
  DB.persist(country3)

  val countries:java.util.List[Country] = DB.createQuery("from Country").findAll.underlying
  println("countries = " + countries)

  DB.close()

  println("Bye-bye, Scala-JPA!")



}
