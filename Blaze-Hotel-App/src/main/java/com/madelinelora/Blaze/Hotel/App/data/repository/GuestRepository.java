package com.madelinelora.Blaze.Hotel.App.data.repository;

import com.madelinelora.Blaze.Hotel.App.data.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}
