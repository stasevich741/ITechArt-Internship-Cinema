package cinema.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Ticket {

    Long id;
    int userId;
    String film;
    int seatPlace;
    BigDecimal price;
    boolean isBought;
}
