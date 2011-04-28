/*
 * Created by IntelliJ IDEA.
 * User: ceki
 * Date: 21.04.11
 * Time: 17:34
 */
package gt201104;

class TamedAddress(val underlying: Address) extends Tamed[Address] {

  def line0 = underlying.getLine0
  def line0_=(in: String) = underlying.setLine0(in)

  def line1 = underlying.getLine1
  def line1_=(in: String) = underlying.setLine1(in)

  def zip = underlying.getZip
  def zip_=(in: String) = underlying.setZip(in)

  def city = underlying.getCity
  def city_=(in: String) = underlying.setCity(in)
}

object TamedAddress {
  implicit def convertDown(t: TamedAddress): Address = t.underlying
}

