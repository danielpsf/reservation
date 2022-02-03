package labs.danielpsf.reservation.reservation;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import labs.danielpsf.reservation.user.User;
import labs.danielpsf.reservation.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Transactional
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(final ReservationRepository reservationRepository,
            final UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<ReservationDTO> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .collect(Collectors.toList());
    }

    public ReservationDTO get(final UUID id) {
        return reservationRepository.findById(id)
                .map(reservation -> mapToDTO(reservation, new ReservationDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UUID create(final ReservationDTO reservationDTO) {
        final Reservation reservation = new Reservation();
        mapToEntity(reservationDTO, reservation);
        return reservationRepository.save(reservation).getId();
    }

    public void update(final UUID id, final ReservationDTO reservationDTO) {
        final Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(reservationDTO, reservation);
        reservationRepository.save(reservation);
    }

    public void delete(final UUID id) {
        reservationRepository.deleteById(id);
    }

    private ReservationDTO mapToDTO(final Reservation reservation,
            final ReservationDTO reservationDTO) {
        reservationDTO.setId(reservation.getId());
        reservationDTO.setReservationTime(reservation.getReservationTime());
        reservationDTO.setOcupationStartTime(reservation.getOcupationStartTime());
        reservationDTO.setOcupationEndTime(reservation.getOcupationEndTime());
        reservationDTO.setCreatedBy(reservation.getCreatedBy());
        reservationDTO.setReservationUsers(reservation.getReservationUserUsers() == null ? null : reservation.getReservationUserUsers().stream()
                .map(user -> user.getId())
                .collect(Collectors.toList()));
        return reservationDTO;
    }

    private Reservation mapToEntity(final ReservationDTO reservationDTO,
            final Reservation reservation) {
        reservation.setReservationTime(reservationDTO.getReservationTime());
        reservation.setOcupationStartTime(reservationDTO.getOcupationStartTime());
        reservation.setOcupationEndTime(reservationDTO.getOcupationEndTime());
        reservation.setCreatedBy(reservationDTO.getCreatedBy());
        if (reservationDTO.getReservationUsers() != null) {
            final List<User> reservationUsers = userRepository.findAllById(reservationDTO.getReservationUsers());
            if (reservationUsers.size() != reservationDTO.getReservationUsers().size()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "one of reservationUsers not found");
            }
            reservation.setReservationUserUsers(reservationUsers.stream().collect(Collectors.toSet()));
        }
        return reservation;
    }

}
