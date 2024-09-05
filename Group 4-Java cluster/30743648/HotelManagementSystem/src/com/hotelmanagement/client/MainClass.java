package com.hotelmanagement.client;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import com.hotelmanagement.dao.GuestDAO;
import com.hotelmanagement.dao.ReservationDAO;
import com.hotelmanagement.dao.RoomDAO;
import com.hotelmanagement.exception.GuestNotFoundException;
import com.hotelmanagement.exception.ReservationNotFoundException;
import com.hotelmanagement.exception.RoomNotFoundException;
import com.hotelmanagement.model.Guest;
import com.hotelmanagement.model.Reservation;
import com.hotelmanagement.model.Room;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoomDAO roomDAO = new RoomDAO();
        GuestDAO guestDAO = new GuestDAO();
        ReservationDAO reservationDAO = new ReservationDAO();

        int option;
        do {
            System.out.println("\nHotel Management System");
            System.out.println("=============================");
            System.out.println("1. Room Management");
            System.out.println("2. Guest Management");
            System.out.println("3. Reservation Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    handleRoomManagement(sc, roomDAO);
                    break;

                case 2:
                    handleGuestManagement(sc, guestDAO);
                    break;

                case 3:
                    handleReservationManagement(sc, reservationDAO);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 4);

        sc.close();
    }

    private static void handleRoomManagement(Scanner sc, RoomDAO roomDAO) {
        int option;
        do {
            System.out.println("\nRoom Management");
            System.out.println("=============================");
            System.out.println("1. Add a new room");
            System.out.println("2. View room details");
            System.out.println("3. Update room information");
            System.out.println("4. Delete a room");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Add Room
                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter room type: ");
                    String type = sc.nextLine();

                    System.out.print("Enter price per night: ");
                    double pricePerNight = sc.nextDouble();


                    Room room = new Room(roomNumber, type, pricePerNight, true);
                    try {
                        roomDAO.addRoom(room);
                    } catch (SQLException e) {
                        System.err.println("Error adding room: " + e.getMessage());
                    }
                    break;

                case 2:
                    // View Room
                    System.out.print("Enter room number: ");
                    int viewRoomNumber = sc.nextInt();
                    try {
                        Room viewRoom = roomDAO.getRoom(viewRoomNumber);
                        System.out.println("Room Number: " + viewRoom.getRoomNumber());
                        System.out.println("Type: " + viewRoom.getType());
                        System.out.println("Price per Night: " + viewRoom.getPricePerNight());
                        System.out.println("Availability Status: " + (viewRoom.isAvailabilityStatus() ? "Available" : "Occupied"));
                    } catch (SQLException | RoomNotFoundException e) {
                        System.err.println("Error retrieving room: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Update Room
                    System.out.print("Enter room number to update: ");
                    int updateRoomNumber = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    try {
                        Room updateRoom = roomDAO.getRoom(updateRoomNumber);

                        System.out.print("Enter new room type (leave blank to keep current): ");
                        String newType = sc.nextLine();
                        if (!newType.isEmpty()) {
                            updateRoom.setType(newType);
                        }

                        System.out.print("Enter new price per night (leave blank to keep current): ");
                        String newPricePerNight = sc.nextLine();
                        if (!newPricePerNight.isEmpty()) {
                            updateRoom.setPricePerNight(Double.parseDouble(newPricePerNight));
                        }

                        System.out.print("Enter new availability status (true/false, leave blank to keep current): ");
                        String newAvailabilityStatus = sc.nextLine();
                        if (!newAvailabilityStatus.isEmpty()) {
                            updateRoom.setAvailabilityStatus(Boolean.parseBoolean(newAvailabilityStatus));
                        }

                        roomDAO.updateRoom(updateRoom);
                    } catch (SQLException | RoomNotFoundException e) {
                        System.err.println("Error updating room: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Delete Room
                    System.out.print("Enter room number to delete: ");
                    int deleteRoomNumber = sc.nextInt();
                    try {
                        roomDAO.deleteRoom(deleteRoomNumber);
                    } catch (SQLException e) {
                        System.err.println("Error deleting room: " + e.getMessage());
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 5);
    }

    private static void handleGuestManagement(Scanner sc, GuestDAO guestDAO) {
        int option;
        do {
            System.out.println("\nGuest Management");
            System.out.println("=============================");
            System.out.println("1. Register a new guest");
            System.out.println("2. View guest details");
            System.out.println("3. Update guest information");
            System.out.println("4. Delete a guest");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Register Guest
                    System.out.print("Enter guest ID: ");
                    int guestId = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    System.out.print("Enter guest name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter guest email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter guest phone number: ");
                    String phoneNumber = sc.nextLine();

                    System.out.print("Enter guest address: ");
                    String address = sc.nextLine();

                    Guest guest = new Guest(guestId, name, email, phoneNumber, address);
                    try {
                        guestDAO.addGuest(guest);
                    } catch (SQLException e) {
                        System.err.println("Error adding guest: " + e.getMessage());
                    }
                    break;

                case 2:
                    // View Guest
                    System.out.print("Enter guest ID: ");
                    int viewGuestId = sc.nextInt();
                    try {
                        Guest viewGuest = guestDAO.getGuest(viewGuestId);
                        System.out.println("Guest ID: " + viewGuest.getGuestId());
                        System.out.println("Name: " + viewGuest.getName());
                        System.out.println("Email: " + viewGuest.getEmail());
                        System.out.println("Phone Number: " + viewGuest.getPhoneNumber());
                        System.out.println("Address: " + viewGuest.getAddress());
                    } catch (SQLException | GuestNotFoundException e) {
                        System.err.println("Error retrieving guest: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Update Guest
                    System.out.print("Enter guest ID to update: ");
                    int updateGuestId = sc.nextInt();
                    sc.nextLine(); // Consume newline

                    try {
                        Guest updateGuest = guestDAO.getGuest(updateGuestId);

                        System.out.print("Enter new guest name (leave blank to keep current): ");
                        String newName = sc.nextLine();
                        if (!newName.isEmpty()) {
                            updateGuest.setName(newName);
                        }

                        System.out.print("Enter new guest email (leave blank to keep current): ");
                        String newEmail = sc.nextLine();
                        if (!newEmail.isEmpty()) {
                            updateGuest.setEmail(newEmail);
                        }

                        System.out.print("Enter new guest phone number (leave blank to keep current): ");
                        String newPhoneNumber = sc.nextLine();
                        if (!newPhoneNumber.isEmpty()) {
                            updateGuest.setPhoneNumber(newPhoneNumber);
                        }

                        System.out.print("Enter new guest address (leave blank to keep current): ");
                        String newAddress = sc.nextLine();
                        if (!newAddress.isEmpty()) {
                            updateGuest.setAddress(newAddress);
                        }

                        guestDAO.updateGuest(updateGuest);
                    } catch (SQLException | GuestNotFoundException e) {
                        System.err.println("Error updating guest: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Delete Guest
                    System.out.print("Enter guest ID to delete: ");
                    int deleteGuestId = sc.nextInt();
                    try {
                        guestDAO.deleteGuest(deleteGuestId);
                    } catch (SQLException e) {
                        System.err.println("Error deleting guest: " + e.getMessage());
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 5);
    }

    private static void handleReservationManagement(Scanner sc, ReservationDAO reservationDAO) {
        int option;
        do {
            System.out.println("\nReservation Management");
            System.out.println("=============================");
            System.out.println("1. Make a new reservation");
            System.out.println("2. View reservation details");
            System.out.println("3. Update reservation information");
            System.out.println("4. Cancel a reservation");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    // Make Reservation
                    System.out.print("Enter reservation ID: ");
                    int reservationId = sc.nextInt();

                    System.out.print("Enter room number: ");
                    int roomNumber = sc.nextInt();

                    System.out.print("Enter guest ID: ");
                    int guestId = sc.nextInt();

                    System.out.print("Enter check-in date (yyyy-mm-dd): ");
                    Date checkInDate = Date.valueOf(sc.next());

                    System.out.print("Enter check-out date (yyyy-mm-dd): ");
                    Date checkOutDate = Date.valueOf(sc.next());

                    System.out.print("Enter total price: ");
                    double totalPrice = sc.nextDouble();

                    Reservation reservation = new Reservation(reservationId, roomNumber, guestId, checkInDate, checkOutDate, totalPrice);
                    try {
                        reservationDAO.addReservation(reservation);
                    } catch (SQLException e) {
                        System.err.println("Error adding reservation: " + e.getMessage());
                    }
                    break;

                case 2:
                    // View Reservation
                    System.out.print("Enter reservation ID: ");
                    int viewReservationId = sc.nextInt();
                    try {
                        Reservation viewReservation = reservationDAO.getReservation(viewReservationId);
                        System.out.println("Reservation ID: " + viewReservation.getReservationId());
                        System.out.println("Room Number: " + viewReservation.getRoomNumber());
                        System.out.println("Guest ID: " + viewReservation.getGuestId());
                        System.out.println("Check-in Date: " + viewReservation.getCheckInDate());
                        System.out.println("Check-out Date: " + viewReservation.getCheckOutDate());
                        System.out.println("Total Price: " + viewReservation.getTotalPrice());
                    } catch (SQLException | ReservationNotFoundException e) {
                        System.err.println("Error retrieving reservation: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Update Reservation
                    System.out.print("Enter reservation ID to update: ");
                    int updateReservationId = sc.nextInt();

                    try {
                        Reservation updateReservation = reservationDAO.getReservation(updateReservationId);

                        System.out.print("Enter new room number (leave blank to keep current): ");
                        String newRoomNumber = sc.nextLine();
                        if (!newRoomNumber.isEmpty()) {
                            updateReservation.setRoomNumber(Integer.parseInt(newRoomNumber));
                        }

                        System.out.print("Enter new guest ID (leave blank to keep current): ");
                        String newGuestId = sc.nextLine();
                        if (!newGuestId.isEmpty()) {
                            updateReservation.setGuestId(Integer.parseInt(newGuestId));
                        }

                        System.out.print("Enter new check-in date (yyyy-mm-dd, leave blank to keep current): ");
                        String newCheckInDate = sc.nextLine();
                        if (!newCheckInDate.isEmpty()) {
                            updateReservation.setCheckInDate(Date.valueOf(newCheckInDate));
                        }

                        System.out.print("Enter new check-out date (yyyy-mm-dd, leave blank to keep current): ");
                        String newCheckOutDate = sc.nextLine();
                        if (!newCheckOutDate.isEmpty()) {
                            updateReservation.setCheckOutDate(Date.valueOf(newCheckOutDate));
                        }

                        System.out.print("Enter new total price (leave blank to keep current): ");
                        String newTotalPrice = sc.nextLine();
                        if (!newTotalPrice.isEmpty()) {
                            updateReservation.setTotalPrice(Double.parseDouble(newTotalPrice));
                        }

                        reservationDAO.updateReservation(updateReservation);
                    } catch (SQLException | ReservationNotFoundException e) {
                        System.err.println("Error updating reservation: " + e.getMessage());
                    }
                    break;

                case 4:
                    // Cancel Reservation
                    System.out.print("Enter reservation ID to cancel: ");
                    int cancelReservationId = sc.nextInt();
                    try {
                        reservationDAO.cancelReservation(cancelReservationId);
                    } catch (SQLException e) {
                        System.err.println("Error canceling reservation: " + e.getMessage());
                    }
                    break;

                case 5: 
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        } while (option != 5);
    }
}
