package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
