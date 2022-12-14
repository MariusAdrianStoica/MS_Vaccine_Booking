package se.lexicon.dao;

import se.lexicon.model.Booking;
import se.lexicon.model.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDaoImpl implements BookingDao{

    private List<Booking> bookingList;
    
    public BookingDaoImpl(){
        bookingList = new ArrayList<>();
    }

    @Override
    public void generateBookingTable(LocalDate startDate, int numberOfDays) {
        LocalTime startTime = LocalTime.parse("08:00");

        for(int i=0; i<numberOfDays;i++){
            for (int j=0 ; j<10; j++){
                Booking booking= new Booking(
                        LocalDateTime.of(startDate.plusDays(i),startTime.plusHours(j)),
                        0,
                        "CV4"
                );
                bookingList.add(booking);
            }
        }

    }

    @Override
    public List<Booking> findByDateBetween(LocalDate start, LocalDate end) {
        List<Booking> filteredList = new ArrayList<>();
        for( Booking booking: bookingList){
            LocalDate bookingDate = booking.getDateTime().toLocalDate(); //convert datetime to date
            if ((bookingDate.isAfter(start)||bookingDate.isEqual(start)) &&
                    (bookingDate.isBefore(end) || bookingDate.isEqual(end))){
                filteredList.add(booking);
            }
        }
        return filteredList;
    }

    @Override
    public List<Booking> findByDate(LocalDate date) {
        List<Booking> filteredList = new ArrayList<>();
        for (Booking booking : bookingList) {
            LocalDate bookingDate = booking.getDateTime().toLocalDate(); //convert datetime to date
            if (bookingDate.isEqual(date)){
                filteredList.add(booking);
            }
        }
        return filteredList;
    }

    @Override
    public boolean reserve(String bookingId, Patient patient) {
        for (Booking booking : bookingList) {
            if (booking.isVacant() && booking.getId().equalsIgnoreCase(bookingId)){
                booking.setPatient(patient);
                return true;
            }

        }

        return false;
    }

    @Override
    public boolean cancel(String bookingId, Patient patient) {
        for (Booking booking : bookingList) {
            if (!booking.isVacant() && booking.getId().equalsIgnoreCase(bookingId)){
                booking.setPatient(null);
                return true;
            }

        }
        return false;
    }

    @Override
    public List<Booking> findBookingBySsn(String Ssn) {
        List<Booking> filteredList = new ArrayList<>();
        for (Booking booking: bookingList){
            if (booking.getPatient()!= null && booking.getPatient().getSsn().equalsIgnoreCase(Ssn)){
                filteredList.add(booking);
            }
        }
        return filteredList;
    }
}
