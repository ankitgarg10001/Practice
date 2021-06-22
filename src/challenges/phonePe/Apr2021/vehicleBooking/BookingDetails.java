package challenges.phonePe.Apr2021.vehicleBooking;

import java.time.LocalDateTime;

public class BookingDetails {

    private LocalDateTime bookingStartTime;
    private LocalDateTime bookingEndTime;
    private Person owner;


    public BookingDetails(LocalDateTime bookingStartTime, LocalDateTime bookingEndTime, Person owner) {
        this.bookingStartTime = bookingStartTime;
        this.bookingEndTime = bookingEndTime;
        this.owner = owner;
    }

    public LocalDateTime getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(LocalDateTime bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public LocalDateTime getBookingEndTime() {
        return bookingEndTime;
    }

    public void setBookingEndTime(LocalDateTime bookingEndTime) {
        this.bookingEndTime = bookingEndTime;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
