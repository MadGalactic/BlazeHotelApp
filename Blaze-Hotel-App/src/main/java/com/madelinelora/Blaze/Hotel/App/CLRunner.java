package com.madelinelora.Blaze.Hotel.App;


import com.madelinelora.Blaze.Hotel.App.data.entity.Room;
import com.madelinelora.Blaze.Hotel.App.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

// this shows the simplest way to create a repository to access spring data

@Component
public class CLRunner implements CommandLineRunner {


    private final RoomRepository roomRepository;

    // requires that Spring has a room repository that it can inject into the class
    public CLRunner(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    // allows you to see data through the embedded database, as of yet there is no postgres database
    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = this.roomRepository.findAll();
        Optional<Room> room = this.roomRepository.findByRoomNumberIgnoreCase("p1");
        System.out.println(room);
        rooms.forEach(System.out::println);

    }

}
