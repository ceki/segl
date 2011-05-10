package gt201104


class TamedPhone(val underlying: Phone) extends Tamed[Phone] {


  def areaCode = underlying.getAreaCode
  def areaCode_=(in: String) = underlying.setAreaCode(in)

  def number = underlying.getNumber
  def number_=(in: String) = underlying.setNumber(in)
}

object TamedPhone {
  implicit def convertDown(t: TamedPhone): Phone = t.underlying
}
