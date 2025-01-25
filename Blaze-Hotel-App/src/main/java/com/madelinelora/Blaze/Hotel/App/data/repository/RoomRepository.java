package com.madelinelora.Blaze.Hotel.App.data.repository;

import com.madelinelora.Blaze.Hotel.App.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    Optional<Room> findByRoomNumberIgnoreCase(String roomNumber);
}
