package de.traveltainment.model

import javax.persistence._
import scala.beans.BeanProperty
import scala.annotation.meta.field
import de.traveltainment.model.util.{CrudDAO, DynamixEntity}
import scala.util.parsing.json.{JSONFormat, JSON}

@Entity
@Table(name = "country")
class Country(n:String,c:String) extends DynamixEntity {

  @(Id @field)
  @(GeneratedValue @field)(strategy = GenerationType.AUTO)
  @BeanProperty
  override var id:Long = _

  @BeanProperty
  var name:String = n

  @BeanProperty
  var capital:String = c

  def this() = this(null, null)

  override def toString = {
    "%s{id = %s, name = %s, capital = %s}".
      format(this.getClass.getSimpleName, id, name, capital)
  }

}

@NamedQuery(name = "Country.findAll",query = "from Country c ")
object Country extends CrudDAO[Country] {

  def apply(n:String,c:String) = new Country(n,c)

}