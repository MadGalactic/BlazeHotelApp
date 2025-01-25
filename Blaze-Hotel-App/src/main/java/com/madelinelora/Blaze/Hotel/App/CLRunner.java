package com.madelinelora.Blaze.Hotel.App;


import com.madelinelora.Blaze.Hotel.App.data.entity.Guest;
import com.madelinelora.Blaze.Hotel.App.data.entity.Reservation;
import com.madelinelora.Blaze.Hotel.App.data.entity.Room;
import com.madelinelora.Blaze.Hotel.App.data.repository.GuestRepository;
import com.madelinelora.Blaze.Hotel.App.data.repository.ReservationRepository;
import com.madelinelora.Blaze.Hotel.App.data.repository.RoomRepository;
import com.madelinelora.Blaze.Hotel.App.service.RoomReservationService;
import com.madelinelora.Blaze.Hotel.App.service.model.RoomReservation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// this shows the simplest way to create a repository to access spring data

@Component
public class CLRunner implements CommandLineRunner {


    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomReservationService roomReservationService;

    // requires that Spring has a room repository that it can inject into the class
    public CLRunner(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository, RoomReservationService roomReservationService) {
        this.roomRepository = roomRepository;
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomReservationService = roomReservationService;
    }

    // allows you to see data through the embedded database, as of yet there is no postgres database
    @Override
    public void run(String... args) throws Exception {
       List<RoomReservation> reservations = this.roomReservationService.getRoomReservationsForDate("2023-08-28");
       reservations.forEach(System.out::println);
    }

}
