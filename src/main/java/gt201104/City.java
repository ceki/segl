package gt201104;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ceki G&uuml;c&uuml;
 */
public class City {

  private String name;
  private List<House> houseList;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<House> getHouses() {
    if(houseList == null) {
      houseList = new ArrayList<House>();
    }
    return houseList;
  }

}
