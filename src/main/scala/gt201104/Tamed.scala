/*
 * Created by IntelliJ IDEA.
 * User: ceki
 * Date: 21.04.11
 * Time: 17:40
 */
package gt201104;

abstract class Tamed[U <: AnyRef] {
  val underlying: U
}