package cinema.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ticket {

    private Long id;
    private int userId;
    private String film;
    private int seatPlace;
    private BigDecimal price;
    private boolean isBought;
}
