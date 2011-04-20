package gt201104;

/**
 * @author Ceki G&uuml;c&uuml;
 */
public class CityServiceBuilder {


  static CityService build() {
    CityService service = new CityService();
    City lausanne = new City();
    lausanne.setName("Lausanne");

    {
      Person person = new Person();

      person.setId(0);
      person.setFirstName("Jack");
      person.setLastName("Ofalltrades");

      Address address = new Address();
      address.setLine0("rue de Bourg 0");
      address.setZip("1003");
      address.setCity("Lausanne");

      Phone phone = new Phone();
      phone.setAreaCode("021");
      phone.setNumber("111 11 11");

      House house = new House();
      house.setOwner(person);
      house.setAddress(address);
      house.setColor(Color.YELLOW);
      house.getPhones().add(phone);
      lausanne.getHouses().add(house);
    }

    {
      Person person = new Person();

      person.setId(1);
      person.setFirstName("Master");
      person.setLastName("Ofnone");

      Address address = new Address();
      address.setLine0("rue Centrale 123");
      address.setZip("1003");
      address.setCity("Lausanne");

      Phone phone = new Phone();
      phone.setNumber("021 111 11 12");

      House house = new House();
      house.setOwner(person);
      house.setAddress(address);
      house.setColor(Color.BLUE);
      house.getPhones().add(phone);
      lausanne.getHouses().add(house);
    }
    service.add(lausanne);
    return service;
  }
}
