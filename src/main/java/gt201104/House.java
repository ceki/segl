package gt201104;

import java.util.ArrayList;
import java.util.List;

public class House {
  private Person owner;
  private Color color;
  private Address address;
  private List<Phone> phoneList;

  public Person getOwner() {
    return owner;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<Phone> getPhones() {
    if (phoneList == null) {
      phoneList = new ArrayList<Phone>();
    }
    return phoneList;
  }
}
