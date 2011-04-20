package gt201104;

import java.util.ArrayList;
import java.util.List;

public class CityService {

  List<City> registry = new ArrayList<City>();

  void add(City city) {
    if (registry.contains(city)) {
      throw new IllegalArgumentException(city + " already in registry");
    }
    registry.add(city);
  }

  public City search(String name) {
    for (City c : registry) {
      if (name.equals(c.getName()))
        return c;
    }
    return null;
  }

}
