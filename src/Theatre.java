// Name: Mithuna Chandrasekaran
// Student ID: w1956134
// Date:22/03/2023

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Define the class with the Theatre method
public class Theatre {
    static int[] row_1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // row 1 has 12 seats
    static int[] row_2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // row 2 has 16 seats
    static int[] row_3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; // row 3 has 20 seats
    static Scanner input = new Scanner(System.in); // Create a static Scanner object named "input" to read input from the user

    // Initializing a boolean variable to control the program loop
    static boolean done = true;

    // Create a static ArrayList object named "tickets" to store Ticket objects
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static String name;
    static String surname;
    static String email;

    // The main method that is executed when the program is run
    public static void main(String[] args) {
         // Starting the program with a welcome message
         System.out.println("\n ***WELCOME TO THE NEW THEATRE***");
         String z = "-";
         System.out.println(z.repeat(50));

         // Keep looping until done is set to false
         while (done) {
             try{
                 // Call the menu() function to display the available options to the user
                 menu();

                 // Prompt the user to enter an option
                 System.out.print("Enter option:");

                 // Get the user's input as an integer
                 int option = input.nextInt();

                 // Use a switch statement to determine which function to call based on the user's input
                 switch (option) {
                     case 1 -> buy_ticket();             // If the user chooses option 1, call the buy_ticket method
                     case 2 -> print_seating_area();     // If the user chooses option 2, call the print_seating_area method
                     case 3 -> cancel_ticket();          // If the user chooses option 3, call the cancel_ticket method
                     case 4 -> show_available();         // If the user chooses option 4, call the show_available method
                     case 5 -> {                         // If the user chooses option 5, call the save method to write the Ticket objects to a file
                         save();
                         System.out.println("Successfully wrote to the file!!!");
                         System.out.println();
                     }
                     case 6 -> load();                   // If the user chooses option 6, call the load method to read the Ticket objects from a file
                     case 7 -> show_tickets_info();      // If the user chooses option 7, call the show_tickets_info method to display information about the purchased tickets
                     case 8 -> sort_tickets();           // If the user chooses option 8, call the sort_tickets method to sort the purchased tickets
                     case 0 -> {
                         // If the user chooses option 0, exit the program by setting the done variable to false
                         System.out.println("***********EXITING PROGRAM***********");
                         done = false;
                     }
                     // If the user chooses an invalid option, print an error message
                     default -> System.out.println("Invalid choice, Please enter a valid option!!! \n");
                 }
             } catch (Exception e){
                 System.out.println("### Invalid Input ###");       // Catch any exception thrown by the code in the try block and print an error message
                 System.out.println();
                     input.nextLine();
             }
         }
    }

    // This method displays the menu options for the user to choose from
    public static void menu() {
        System.out.println("Please select an option: ");
        System.out.println("1) Buy a ticket");
        System.out.println("2) Print seating area");
        System.out.println("3) Cancel ticket");
        System.out.println("4) List available seats");
        System.out.println("5) Save to file");
        System.out.println("6) Load from file");
        System.out.println("7) Print ticket information and total price");
        System.out.println("8) Sort tickets by price");
        System.out.println("0) Quit");
        String z = "-";
        System.out.println(z.repeat(50));
    }

    // This method is called when the user selects the "Buy a ticket" option
    public static void buy_ticket() {
        // Initialize variables for the ticket price, row number, and seat number
        int price = 0;
        int rowNo = 0;
        int seatNo = 0;

                // Ask user for name, validate input
                while (true) {
                    // Prompt the user to enter their name
                    System.out.print("Please enter your Name : ");
                    name = input.next();
                    // Validate name input using regular expressions
                    if (!name.matches("[a-zA-Z]+") ) {
                        System.out.println("Invalid Name!!!");
                    } else
                        break;
                }
                
                // Ask user for surname, validate input
                while (true) {
                    // Prompt the user to enter their surname
                    System.out.print("Please enter your Surname : ");
                    surname = input.next();
                    // Validate name input using regular expressions
                    if (!surname.matches("[a-zA-Z]+") ) {
                        System.out.println("Invalid Name!!!");
                    } else
                        break;
                }

                // Ask user for email, validate input
                while (true) {
                    //Prompt the user to enter their email
                    System.out.print("Please enter your E-mail : ");
                    email = input.next();

                    // Validate email input using regular expressions
                    if (!email.matches("^(.+)@(\\S+)$")) {
                        System.out.println("Invalid Email");
                    } else
                        break;
                }

        // While loop to keep the program running until the user is done booking seats
        while (done) {
            try {
                System.out.print("Enter the Row no (1-3):");    // Prompt the user to enter the row number
                rowNo = input.nextInt();     // Read the input from the user and store it in rowNo variable

                // Check if the row number entered is within the valid range (1-3)
                if (0 < rowNo && rowNo < 4) {
                    // If the row number is valid, prompt the user to enter the seat number
                    System.out.print("Enter the Seat no :");
                    seatNo = input.nextInt();     // Read the input from the user and store it in seatNo variable

                    if (rowNo == 1) {                           // If user selected row 1
                        if (0 < seatNo && seatNo <= 12) {       // Check if seat number is within valid range for row 1
                            if (row_1[seatNo - 1] == 1) {       // If seat is already booked, print message and exit loop
                                System.out.println("Seat was already booked!!!");
                                System.out.println();
                                continue;
                            } else {                            // Otherwise, book the seat and set the price
                                row_1[seatNo - 1] = 1;
                                System.out.println("Seat was successfully booked!!!");
                                price = 10;                     // The price of the ticket is set as 10
                                break;                          // Exit loop
                            }
                        } else {        // If seat number is not valid for row 1, print message
                            System.out.println("### Invalid Seat No ###");
                        }
                    } else if (rowNo == 2) {                    // If user selected row 2
                        if (0 < seatNo && seatNo <= 16) {       // Check if seat number is within valid range for row 2
                            if (row_2[seatNo - 1] == 1) {       // If seat is already booked, print message and exit loop
                                System.out.println("Seat was already booked!!!");
                                System.out.println();
                                continue;
                            } else {                            // Otherwise, book the seat and set the price
                                row_2[seatNo - 1] = 1;
                                System.out.println("Seat was successfully booked!!!");
                                price = 15;                     // The price of the ticket is set as 15
                                break;                          // Exit loop
                            }
                        } else {        // If seat number is not valid for row 2, print message
                            System.out.println("### Invalid Seat No ###");
                        }
                    } else if (rowNo == 3) {                    // This code checks if the row number is equal to 3.
                        if (0 < seatNo && seatNo <= 20) {       // If the seat number entered by the user is valid for the given row number
                            if (row_3[seatNo - 1] == 1) {       // If the seat has already been booked
                                System.out.println("Seat was already booked!!!");
                                System.out.println();
                                continue;
                            } else {                            // Otherwise, book the seat and set the price
                                row_3[seatNo - 1] = 1;
                                System.out.println("Seat was successfully booked!!!");
                                price = 20;                     // The price of the ticket is set as 20
                                break;                          // Exit loop
                            }
                        } else {
                            System.out.println("### Invalid Seat No ###");      // If seat number is not valid for row 3, print message
                        }
                    }
                } else {
                    System.out.println("### Invalid Row No ###");       // If the row number is not valid
                }
            } catch (InputMismatchException e){
                System.out.println("Please enter valid input.");
                input.nextLine();           // Clear the input buffer to prevent an infinite loop
            }
        }
        // Creating a new Person object with given name, surname and email
        Person person = new Person(name, surname, email);
        // Using that Person object to create a new Ticket object with row number, seat number and price
        Ticket ticket = new Ticket(person, rowNo, seatNo, price);
        // Adding the Ticket object to a list of tickets
        tickets.add(ticket);
        System.out.println(" ");
    }

    public static void print_seating_area() {
        String x = "*";
        String y = x.repeat(11);
        System.out.println("           " + y);
        System.out.println("           *" + " " + " STAGE " + " " + "*");
        System.out.println("           " + y);
        System.out.print("          ");

        // Printing the seating arrangement for the first row
        for (int i = 0; i < row_1.length; i++) {
            if (row_1.length / 2 == i) {
                System.out.print(" ");          // Adding a space in the middle of the row for better visualization
            }
            if (row_1[i] == 0) {                // If the current element in the array is 0, print 'O' to represent an available seat
                System.out.print("O");
            } else {                            // If the current element in the array is not 0, print 'X' to represent a booked seat
                System.out.print("X");
            }
        }
        System.out.println("\n");
        System.out.print("        ");

        // Printing the seating arrangement for the second row
        for (int i = 0; i < row_2.length; i++) {
            if (row_2.length / 2 == i) {
                System.out.print(" ");      // Adding a space in the middle of the row for better visualization
            }
            if (row_2[i] == 0) {            // If the current element in the array is 0, print 'O' to represent an available seat
                System.out.print("O");
            } else {                        // If the current element in the array is not 0, print 'X' to represent a booked seat
                System.out.print("X");
            }
        }
        System.out.println("\n");
        System.out.print("      ");

        // Printing the seating arrangement for the third row
        for (int i = 0; i < row_3.length; i++) {
            if (row_3.length / 2 == i) {
                System.out.print(" ");      // Adding a space in the middle of the row for better visualization
            }
            if (row_3[i] == 0) {            // If the current element in the array is 0, print 'O' to represent an available seat
                System.out.print("O");
            } else {                        // If the current element in the array is not 0, print 'X' to represent a booked seat
                System.out.print("X");
            }
        }
        System.out.println("\n  ");         //adding empty line
        String z = "-";
        System.out.println(z.repeat(50));
        System.out.println("\n  ");         //adding empty line
    }

    public static void cancel_ticket() {

        // Begin a while loop that will continue until the user has finished canceling seats
        while (done) {
            try {
                // Ask the user to enter the row number of the seat they want to cancel
                System.out.print("Enter the row number you want to cancel your reservation :");
                int rowNo = input.nextInt();

                // Check if the row number is valid (between 1 and 3)
                if (0 < rowNo && rowNo < 4) {

                    // Ask the user to enter the seat number of the seat they want to cancel
                    System.out.print("Enter the seat you want to cancel your reservation :");
                    int seatNo = input.nextInt();
                    if (rowNo == 1) {       // If the user entered row number 1
                        if (0 < seatNo && seatNo <= 12) {           // Check if the seat number is valid (between 1 and 12)
                            if (row_1[seatNo - 1] == 1) {           // If the seat is already booked, cancel the reservation and remove it from the ticket list
                                row_1[seatNo - 1] = 0;              // Set the value of the seat in the array to 0 (available)
                                System.out.println("The seat reservation was cancelled!!!");
                                for (Ticket i : tickets) {          // Loop through the ticket list to find the ticket with the specified row and seat number
                                    if (i.rowNo == rowNo && i.seatNo == seatNo) {
                                        tickets.remove(i);          // Remove the ticket from the list
                                        break;
                                    }
                                }
                                break;      // Exit the for loop
                            } else {
                                // If the seat is not already booked, inform the user and exit the while loop
                                System.out.println("There was no reservation for this seat!!!");
                                break;
                            }
                        } else {
                            // If the seat number is invalid, inform the user
                            System.out.println("***INVALID SEAT NO***");
                        }
                    } else if (rowNo == 2) {                        // If the user entered row number 2
                        if (0 < seatNo && seatNo <= 16) {           // Check if the seat number is valid (between 1 and 16)
                            if (row_2[seatNo - 1] == 1) {           // If the seat is already booked, cancel the reservation and remove it from the ticket list
                                row_2[seatNo - 1] = 0;              // Set the value of the seat in the array to 0 (available)
                                System.out.println("The seat reservation was cancelled!!!");
                                for (Ticket i : tickets) {          // Loop through the ticket list to find the ticket with the specified row and seat number
                                    if (i.rowNo == rowNo && i.seatNo == seatNo) {
                                        tickets.remove(i);          // Remove the ticket from the list
                                        break;
                                    }
                                }
                                break;      // Exit the for loop
                            } else {
                                // If the seat is not already booked, inform the user and exit the while loop
                                System.out.println("There was no reservation for this seat!!!");
                                break;
                            }
                        } else {
                            // If the seat number is invalid, inform the user
                            System.out.println("***INVALID SEAT NO***");
                        }
                    } else if (rowNo == 3) {                        // If the user entered row number 3
                        if (0 < seatNo && seatNo <= 20) {           // Check if the seat number is valid (between 1 and 20)
                            if (row_3[seatNo - 1] == 1) {           // If the seat is already booked, cancel the reservation and remove it from the ticket list
                                row_3[seatNo - 1] = 0;              // Set the value of the seat in the array to 0 (available)
                                System.out.println("The seat reservation was cancelled!!!");
                                for (Ticket i : tickets) {          // Loop through the ticket list to find the ticket with the specified row and seat number
                                    if (i.rowNo == rowNo && i.seatNo == seatNo) {
                                        tickets.remove(i);          // Remove the ticket from the list
                                        break;
                                    }
                                }
                                break;      // Exit the for loop
                            } else {
                                // If the seat is not already booked, inform the user and exit the while loop
                                System.out.println("There was no reservation for this seat!!!");
                                break;
                            }
                        } else {
                            // If the seat number is invalid, inform the user
                            System.out.println("***INVALID SEAT NO***");
                        }
                    }
                } else {
                    // If the row number is invalid, inform the user
                    System.out.println("***INVALID ROW NO***");
                }
            } catch (InputMismatchException e){
                System.out.println("Please enter the valid input");
                input.nextLine();               // Clear the input buffer to prevent an infinite loop
            }
        }System.out.println();
    }

    // This method displays the available seats
    public static void show_available() {
        System.out.print("\n Row 1: ");     // Print the row number

        // Loop through each seat in Row 1
        for (int i = 0; i < row_1.length; i++) {
            if (row_1[i] == 1) {        // If the seat is already taken, skip to the next iteration
                continue;
            } else {                    // Otherwise, print the seat number (i + 1) and a comma
                System.out.print(i + 1 + ", ");
            }
        }
        System.out.print("\n Row 2: ");     // Print the row number

        // Loop through each seat in Row 2
        for (int i = 0; i < row_2.length; i++) {
            if (row_2[i] == 1) {        // If the seat is already taken, skip to the next iteration
                continue;
            } else {                    // Otherwise, print the seat number (i + 1) and a comma
                System.out.print(i + 1 + ", ");
            }
        }
        System.out.print("\n Row 3: ");     // Print the row number

        // Loop through each seat in Row 3
        for (int i = 0; i < row_3.length; i++) {
            if (row_3[i] == 1) {        // If the seat is already taken, skip to the next iteration
                continue;
            } else {                    // Otherwise, print the seat number (i + 1) and a comma
                System.out.print(i + 1 + ", ");
            }
        }
        System.out.println("\n");
    }

    // This method saves the current seat status to a file named "Seats.txt"
    public static void save() {
        try {
            // Create a new FileWriter object to write to the file "Seats.txt"
            FileWriter file = new FileWriter("Seats.txt");

            // Iterate over each seat in the first row
            for (int i = 0; i < row_1.length; i++) {
                if (row_1[i] == 1) {                // If the seat is reserved, append a "1" to the file
                    file.append("1");
                } else {                            // If the seat is available, append a "0" to the file
                    file.append("0");
                }
            }
            file.append("\n");                      // Append a new line character to the file to separate the rows
            for (int i = 0; i < row_2.length; i++) {
                if (row_2[i] == 1) {                // If the seat is reserved, append a "1" to the file
                    file.append("1");
                } else {                            // If the seat is available, append a "0" to the file
                    file.append("0");
                }
            }
            file.append("\n");
            for (int i = 0; i < row_3.length; i++) {
                if (row_3[i] == 1) {                // If the seat is reserved, append a "1" to the file
                    file.append("1");
                } else {                            // If the seat is available, append a "0" to the file
                    file.append("0");
                }
            }
            file.close();                           // Close the FileWriter object to save the changes to the file

        } catch (IOException e) {
            // If an exception occurs, print the error message
            System.out.println("File was not created!!!");
        }
    }

    // This method loads seat information from a text file named "Seats.txt"
    public static void load() {
        // Creates a new file object for the "Seats.txt" file
        File load = new File("Seats.txt");
        try {
            Scanner f_load = new Scanner(load);         // Creates a new Scanner object to read from the "Seats.txt" file
            while (f_load.hasNext()) {                  // Loops through each line of the file until there is no more data
                String seat = f_load.nextLine();        // Read the next line from the file

                // If the line is 12 characters long, it represents the first row of seats
                if (seat.length() == 12) {
                    // Iterate through each character in the line and set the corresponding seat status in row_2
                    for (int i = 0; i < row_1.length; i++) {
                        row_1[i] = Character.getNumericValue(seat.charAt(i));
                    }

                    // If the line is 16 characters long, it represents the second row of seats
                } else if (seat.length() == 16) {
                    // Iterate through each character in the line and set the corresponding seat status in row_2
                    for (int i = 0; i < row_2.length; i++) {
                        row_2[i] = Character.getNumericValue(seat.charAt(i));
                    }

                    // If the line is 20 characters long, it represents the third row of seats
                } else if (seat.length() == 20) {
                    // Iterate through each character in the line and set the corresponding seat status in row_3
                    for (int i = 0; i < row_3.length; i++) {
                        row_3[i] = Character.getNumericValue(seat.charAt(i));
                    }
                }
            }
            f_load.close();
            String z = "-";
            System.out.println(z.repeat(50));
            System.out.println("        LOAD FROM FILE");
            System.out.println("   File loaded successfully");
            System.out.println(z.repeat(50));
            System.out.println();
        } catch (FileNotFoundException e) {
            // If an exception occurs, print the error message
            System.out.println("***ERROR***");
        }
    }

    public static void show_tickets_info() {
        // Initialize an integer variable named "total_price" and set its initial value to 0
        int total_price = 0;

        // Loop through all the "Ticket" objects in the "tickets" list
        for (Ticket info : tickets) {
            // Call the "print" method of the current "Ticket" object to display its information
            info.print();
            // Add the price of the current "Ticket" object to the "total_price" variable
            total_price += info.price;
        }

        // Print the total price of all the tickets in the "tickets" list
        System.out.println("Total price : " + total_price+"£");

        // Print a blank line for formatting purposes
        System.out.println();
    }

    public static void sort_tickets() {
        // Initialize an integer variable named "y" and set its initial value to 1
        int y = 1;

        // Loop while "y" is less than or equal to the size of the "tickets" list
        while (y <= tickets.size()) {
            // Loop through the "tickets" list starting from the second element
            for (int i = 1; i <= tickets.size() - 1; i++) {
                // Get the current and previous elements from the "tickets" list
                Ticket object_1 = (Ticket) tickets.get(i -1);
                Ticket object_2 = (Ticket) tickets.get(i);

                // Compare the prices of the two elements
                if (object_1.price > object_2.price) {
                    // If the previous element's price is greater than the current element's price, swap the two elements in the list
                    tickets.set(i-1, object_2);
                    tickets.set(i, object_1);
                }
            }
            // Increment "y" by 1
            y++;
        }

        // Call the "show_tickets_info" method to display the sorted list of tickets
        show_tickets_info();
    }
}

