package gt201104;

class TamedHouse(val underlying: House) extends Tamed[House] {


//  def owner = {
//    val o = underlying.getOwner
//    if(o == null) null else Tamed
//  }

  def phoneList: TamedList[Phone, TamedPhone] = {
    new TamedList[Phone, TamedPhone](underlying.getPhones)
  }
}

object TamedHouse {
  implicit def convertDown(t: TamedHouse) = t.underlying
}

//class TamedApartment(val underlying: Apartment) extends TamedHouse(underlying) {
////}
//
//object TamedApartment {
//  implicit def convertDown(t: TamedApartment) = t.underlying
//}
