package de.traveltainment.model.util

import de.traveltainment.em.Database

trait CrudDAO[T<:DynamixEntity] {

    def create(param:T):Long = {
      Database.persist(param)
      param.id
    }

    def update(param:T):T = {
      Database.persist(param)
      param
    }

    def delete(param:T):Unit = {
      Database.remove(param)
    }

    def find(param:Long)(implicit m : Manifest[T]):Option[T] = {
      Database.find(m.runtimeClass.asInstanceOf[Class[T]],param)
    }
}
