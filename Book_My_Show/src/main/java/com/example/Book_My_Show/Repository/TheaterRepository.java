package com.example.Book_My_Show.Repository;

import com.example.Book_My_Show.Entities.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
}
