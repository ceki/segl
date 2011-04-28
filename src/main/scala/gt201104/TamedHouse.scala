package gt201104;

class TamedHouse(val underlying: House) extends Tamed[House] {



}

object TamedHouse {
  implicit def convertDown(t: TamedHouse) = t.underlying
}
