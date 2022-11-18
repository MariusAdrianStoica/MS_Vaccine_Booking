package se.lexicon;

import se.lexicon.dao.*;
import se.lexicon.model.AppUser;
import se.lexicon.model.Booking;
import se.lexicon.model.Patient;

import java.time.LocalDate;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        AppUserDao storage = new AppUserDaoImpl();
        PatientDao patientStorage = new PatientDaoImpl();
        BookingDao bookingStorage = new BookingDaoImpl();

        // enter from console
        AppUser userData1 = new AppUser("user1", "password1");
        AppUser userData2 = new AppUser("user2", "password2");
        // real registration in database
        AppUser createdAppUser1 = storage.create(userData1); // storage.create(user1);
        AppUser createdAppUser2 = storage.create(userData2); //storage.create(user2);


        //System.out.println("All users: \n"+storage.findAll()+"\n");

        //System.out.println("Find by user name \"test\": " + storage.findByUsername("test"));
        //System.out.println("Find by user name \"user2\": " + storage.findByUsername("user2")+"\n");


        // enter from console
        Patient patientData1 = new Patient("111111-1111","patient1", "patient1.test@test.se",createdAppUser1);
        Patient patientData2 = new Patient("111111-2222","patient2", "patient2.test@test.se",createdAppUser2);

        // real registration in database
        Patient registeredPatient1 = patientStorage.create(patientData1);
        Patient registeredPatient2 = patientStorage.create(patientData2);

        //System.out.println("All patients: \n"+patientStorage.findAll()+"\n");

        // generate BookingTable
        bookingStorage.generateBookingTable(LocalDate.parse("2023-01-01"), 2);
        //List<Booking> bookingList = bookingStorage.findByDate(LocalDate.parse("2023-01-02"));
        List<Booking> bookingList =bookingStorage.findByDateBetween(LocalDate.of(2023,01,01), LocalDate.of(2023,01,06));
        //List<Booking> bookingList = bookingStorage.findByDateBetween(LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-03"));



        //String bookingId1 = bookingList.get(1).getId();
        //String bookingId2 = bookingList.get(3).getId();

        System.out.println("List of bookings between 01-06/01/2023 \n");

        String bookingId1 = bookingList.get(1).getId();
        String bookingId2 = bookingList.get(3).getId();

        for (Booking booking : bookingList){
            System.out.println(booking);
        }
        System.out.println("------------------------------");
        System.out.println("Number of bookings: " +bookingList.size());

        boolean isBooking1 = bookingStorage.reserve(bookingId1, patientData1);
        System.out.println("Booking OK: " +isBooking1);
        System.out.println("------------------------------");
        boolean isBooking2 = bookingStorage.reserve(bookingId2, patientData1);
        System.out.println("Booking OK: " +isBooking2);

        System.out.println("List of bookings after reserve \n");

        for (Booking booking : bookingList){
            System.out.println(booking);
        }

        //boolean isBooking3 = bookingStorage.cancel(bookingId1, patientData1);
        //System.out.println("Cancel Booking OK: " +isBooking3 +"\n");

        System.out.println("List of bookings after cancel: \n");

        for (Booking booking : bookingList){
            System.out.println(booking);
        }
        System.out.println("------------------------------");
        System.out.println(bookingStorage.findBookingBySsn("111111-1111"));
    }
}
