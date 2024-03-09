public class Ticket {
    int rowNo;
    int seatNo;
    int price;
    Person person;

    public Ticket(Person person, int rowNo, int seatNo, int price) {
        this.rowNo = rowNo;
        this.seatNo = seatNo;
        this.price = price;
        this.person = person;
    }

    public void print() {
        System.out.println("Name :" + person.getName());
        System.out.println("Surname :" + person.getSurname());
        System.out.println("Email Address :" + person.getEmail());
        System.out.println("Row Number :" + rowNo);
        System.out.println("Seat Number :" + seatNo);
        System.out.println("Price :" + price+"£");
        System.out.println(" ");
    }
}
