package gt201104;

import java.util.{List => JList}

class TamedList[U <: AnyRef, T <: Tamed[_]](val underlyingList: JList[U])(implicit val manT: Manifest[T], implicit val manU: Manifest[U]) {

  def rawToTamed(u: U): T = {
    val classT: Class[T] = manT.erasure.asInstanceOf[Class[T]]
    val constructor = classT.getConstructor(manU.erasure.asInstanceOf[Class[U]])
    val t: T = constructor.newInstance(u.asInstanceOf[Object])
    t
  }

  def apply(i: Int): T = {
    val u: U = underlyingList.get(i)
    rawToTamed(u)
  }

  def add(u: U) {
     underlyingList.add(u)
  }
  def update(i: Int, u: U) {
    underlyingList.set(i, u)
  }

  def size: Int = underlyingList.size

  def asScalaList(): List[T] = {
    import scala.collection.JavaConversions.JListWrapper
    val scalaBuffer = new JListWrapper[U](underlyingList)
    val scalaArray = scalaBuffer.toArray
    val scalaList: List[T] = List.fromArray(scalaArray).map {
      u => rawToTamed(u)
    }
    scalaList
  }

  def exists(predicate: T => Boolean): Boolean = {
    val list: List[T] = asScalaList
    list.exists(predicate)
  }
}

object TamedList {
  implicit def convertDown(t: TamedList) = t.underlyingList
}



