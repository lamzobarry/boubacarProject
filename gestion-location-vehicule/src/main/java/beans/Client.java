package beans;

import java.util.Objects;

public class Client {

    private final int anneeDeNaissance;
    private final String lastName;
    private final String firstName;


    public Client(int anneeDeNaissance, String lastName, String firstName) {
        this.anneeDeNaissance = anneeDeNaissance;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public int getYearOfBirth() {
        return anneeDeNaissance;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return anneeDeNaissance == client.anneeDeNaissance &&
                lastName.equals(client.lastName) &&
                firstName.equals(client.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anneeDeNaissance, lastName, firstName);
    }


}
