package de.traveltainment

import de.traveltainment.em.Database
import de.traveltainment.model.Country

object Start extends App{

  println("Hello, Scala-JPA!")
  println("check the db " + Database.createNativeQuery("select * from checkTable"))

  val country1 = Country("Moldova", "Chisinau")
  val country2 = Country("Ukraine", "Kiev")
  val country3 = Country("Germany", "Berlin")

  Country.create(country1)
  Database.persist(country2)
  Database.persist(country3)

  val countries:java.util.List[Country] = Database.createQuery("from Country").findAll.underlying
  println("countries = " + countries)

  val savedCountry = Country.find(3)

  savedCountry match {
    case Some(c) => println("saved country = " + savedCountry.get)
    case None => println("the country cannot be found")
  }

  Database.close()

  println("Bye-bye, Scala-JPA!")



}
