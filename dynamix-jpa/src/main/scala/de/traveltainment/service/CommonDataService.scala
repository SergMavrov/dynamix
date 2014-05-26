package de.traveltainment.service

import de.traveltainment.model.Country

object CommonDataService {

  def findAllCountries() = {
    Country.findAll()
  }

}
