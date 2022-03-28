package cinema.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Film {

    private Long id;
    private String name;
    private LocalDateTime timeAndDate;
    private int ticket;
}
