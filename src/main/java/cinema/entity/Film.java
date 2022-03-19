package cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Film {

    Long id;
    String name;
    LocalDateTime timeAndDate;
    int ticket;
}
