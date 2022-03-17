package cinema.entity;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Film {

    Long id;
    String name;
    LocalDateTime timeAndDate;
    int ticket;
}
