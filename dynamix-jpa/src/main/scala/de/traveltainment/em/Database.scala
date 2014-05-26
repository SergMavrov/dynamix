package de.traveltainment.em

import org.scala_libs.jpa.{ThreadLocalEM, LocalEMF}
import de.traveltainment.model.Country

object Database extends LocalEMF("scalaJpa", false) with ThreadLocalEM {

}
