package labs.danielpsf.reservation.reservation;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import labs.danielpsf.reservation.user.User;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
public class Reservation {

    @Id
    @Column(nullable = false, updatable = false, columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid")
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime reservationTime;

    @Column
    private LocalDateTime ocupationStartTime;

    @Column
    private LocalDateTime ocupationEndTime;

    @Column(nullable = false, columnDefinition = "char(36)")
    @Type(type = "uuid-char")
    private UUID createdBy;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "reservation_user",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> reservationUserUsers;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

    @PrePersist
    public void prePersist() {
        dateCreated = OffsetDateTime.now();
        lastUpdated = dateCreated;
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdated = OffsetDateTime.now();
    }

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

    public Set<User> getReservationUserUsers() {
        return reservationUserUsers;
    }

    public void setReservationUserUsers(final Set<User> reservationUserUsers) {
        this.reservationUserUsers = reservationUserUsers;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
