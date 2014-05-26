package de.traveltainment

import de.traveltainment.em.Database
import de.traveltainment.model.Country

/**
 * Created by sergey on 5/25/14.
 */
object Start extends App{

  println("Hello, Scala-JPA!")
  println("check the db " + Database.createNativeQuery("select * from checkTable"))

  val country1 = Country("Moldova", "Chisinau")
  val country2 = Country("Ukraine", "Kiev")
  val country3 = Country("Germany", "Berlin")

  Database.persist(country1)
  Database.persist(country2)
  Database.persist(country3)

  val countries:java.util.List[Country] = Database.createQuery("from Country").findAll.underlying
  println("countries = " + countries)

  Database.close()

  println("Bye-bye, Scala-JPA!")



}
