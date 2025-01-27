package com.madelinelora.Blaze.Hotel.App.web.api;


import com.madelinelora.Blaze.Hotel.App.data.entity.Room;
import com.madelinelora.Blaze.Hotel.App.data.repository.RoomRepository;
import com.madelinelora.Blaze.Hotel.App.web.exception.BadRequestException;
import com.madelinelora.Blaze.Hotel.App.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
public class RoomApiController {

    private final RoomRepository roomRepository;

    public RoomApiController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @PostMapping
    public Room createRoom(@RequestBody Room room) {
       return this.roomRepository.save(room);
    }

    @GetMapping("/{id}")
    public Room getRoom(@PathVariable("id")long id){
        Optional<Room> room = this.roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new NotFoundException("room not found with id: " + id);
        }
        return room.get();
    }

    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable("id")long id, @RequestBody Room room) {
        if (id != room.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return this.roomRepository.save(room);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteRoom(@PathVariable("id")long id){
        this.roomRepository.deleteById(id);
    }

}
