public class Person {
    private String name;
    private String surname;

    private String email_address;


    public Person(String name, String surname, String email_address) {
        this.name = name;
        this.surname = surname;
        this.email_address = email_address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email_address;
    }

}