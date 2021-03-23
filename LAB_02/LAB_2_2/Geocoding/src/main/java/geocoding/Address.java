package geocoding;

import java.util.Objects;

public class Address {

    final String road;
    final String city;
    final String state;
    final String zip;
    final String houseNumber;

    public Address(String houseNumber, String road, String city, String state, String zip) {
        this.houseNumber = houseNumber;
        this.road = road;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "road='" + road + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(road, address.road) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zip, address.zip) && Objects.equals(houseNumber, address.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(road, city, state, zip, houseNumber);
    }
}
