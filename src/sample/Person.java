package sample;

public class Person {
    private String name;
    private String ssn;

    public Person(String name, String ssn) {
        this.name = name;
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public String getSsn() {
        return ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public int hashCode() {
        return ssn.hashCode();
    }

    @Override
    public String toString() {
        return name + " (ssn: " + ssn + ")";
    }

    // type: eq... en selecteer vervolgens juiste velden
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ssn.equals(person.ssn);
    }
}
