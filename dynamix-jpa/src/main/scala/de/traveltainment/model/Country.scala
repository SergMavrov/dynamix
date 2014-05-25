package de.traveltainment.model

import javax.persistence._
import scala.beans.BeanProperty
import scala.annotation.meta.field

/**
 * Created by sergey on 5/25/14.
 */
@Entity
@Table(name = "country")
class Country(n:String,c:String) {

  @(Id @field)
  @(GeneratedValue @field)(strategy = GenerationType.AUTO)
  @BeanProperty
  var id:Int = _

  @BeanProperty
  var name:String = n

  @BeanProperty
  var capital:String = c

  def this() = this(null, null)

  override def toString = id + " = " + name + " " + capital

}

object Country {

  def apply(n:String,c:String) = new Country(n,c)

}