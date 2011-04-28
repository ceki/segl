/*
 * Created by IntelliJ IDEA.
 * User: ceki
 * Date: 21.04.11
 * Time: 17:43
 */
package gt201104;

class TamedPerson(val underlying: Person) extends Tamed[Person] {



}

object TamedPerson {
  implicit def convertDown(t: TamedPerson) = t.underlying
}