package com.madelinelora.Blaze.Hotel.App.web.api;


import com.madelinelora.Blaze.Hotel.App.data.entity.Guest;
import com.madelinelora.Blaze.Hotel.App.data.repository.GuestRepository;
import com.madelinelora.Blaze.Hotel.App.data.repository.RoomRepository;
import com.madelinelora.Blaze.Hotel.App.web.exception.BadRequestException;
import com.madelinelora.Blaze.Hotel.App.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {

    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllGuests() {
        return this.guestRepository.findAll();
    }

    @PostMapping
    public Guest createGuest(@RequestBody Guest guest) {
        return this.guestRepository.save(guest);
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id){
        Optional<Guest> guest = this.guestRepository.findById(id);
        if(guest.isEmpty()) {
            throw new NotFoundException("guest not found with id: " + id);
        }
        return guest.get();
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id")long id, @RequestBody Guest guest) {
        if (id != guest.getId()) {
            throw new BadRequestException("id on path doesn't match body");
        }
        return this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id")long id) {
        this.guestRepository.deleteById(id);
    }

}
