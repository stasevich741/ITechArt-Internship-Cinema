package cinema.entity;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket {

    private Long id;
    private int userId;
    private String film;
    private int seatPlace;
    private BigDecimal price;
    private boolean isBought;
}
