package com.example.Book_My_Show.Entities;


import com.example.Book_My_Show.Enums.ShowType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private LocalDate showDate;

  private LocalTime showTime;


  @Enumerated(value = EnumType.STRING)
  private ShowType showType;

  @CreationTimestamp
  private Date createdOn;

  @UpdateTimestamp
  private Date updatedOn;


  //This is child wrt to the movieEntity
  @ManyToOne
  @JoinColumn
  private MovieEntity movieEntity;


  @ManyToOne
  @JoinColumn
  private TheaterEntity theaterEntity;

  //Show is parent wrt to ticket
  @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
  private List<TicketEntity> listOfBookedTickets = new ArrayList<>();

  @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
  private List<ShowSeatEntity> listOfShowSeats = new ArrayList<>();


}
