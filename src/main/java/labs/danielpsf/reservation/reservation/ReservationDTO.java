package labs.danielpsf.reservation.reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;


public class ReservationDTO {

    private UUID id;

    @NotNull
    private LocalDateTime reservationTime;

    private LocalDateTime ocupationStartTime;

    private LocalDateTime ocupationEndTime;

    @NotNull
    private UUID createdBy;

    private List<UUID> reservationUsers;

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(final LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDateTime getOcupationStartTime() {
        return ocupationStartTime;
    }

    public void setOcupationStartTime(final LocalDateTime ocupationStartTime) {
        this.ocupationStartTime = ocupationStartTime;
    }

    public LocalDateTime getOcupationEndTime() {
        return ocupationEndTime;
    }

    public void setOcupationEndTime(final LocalDateTime ocupationEndTime) {
        this.ocupationEndTime = ocupationEndTime;
    }

    public UUID getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final UUID createdBy) {
        this.createdBy = createdBy;
    }

    public List<UUID> getReservationUsers() {
        return reservationUsers;
    }

    public void setReservationUsers(final List<UUID> reservationUsers) {
        this.reservationUsers = reservationUsers;
    }

}
