package labs.danielpsf.reservation.reservation;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
}
