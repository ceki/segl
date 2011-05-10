
package gt201104

class TamedCity(val underlying: City) extends Tamed[City] {
  def name = underlying.getName
  def name_=(in: String) = underlying.setName(in)

  def houseList: TamedList[House, TamedHouse] = {
    new TamedList[House, TamedHouse](underlying.getHouses)
  }

}

object TamedCity {
  implicit def convertDown(t: TamedCity): City = t.underlying
}

