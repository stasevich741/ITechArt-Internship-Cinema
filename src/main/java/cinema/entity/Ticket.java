package cinema.entity;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class Ticket {

    Long id;
    int userId;
    String film;
    int seatPlace;
    BigDecimal price;
    boolean isBought;
}
