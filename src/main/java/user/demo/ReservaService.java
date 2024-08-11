package user.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public Reserva crearReserva(Reserva reserva) {
        // Lógica para verificar disponibilidad
        return reservaRepository.save(reserva);
    }

    public Reserva obtenerReserva(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva actualizarReserva(Long id, Reserva reserva) {
        if (reservaRepository.existsById(id)) {
            reserva.setId(id);
            return reservaRepository.save(reserva);
        }
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void eliminarReserva(Long id) {
        ReactiveCrudRepository.deleteById(id);
    }
    private final MySQLReservaRepository mySQLRepository;
    private final MongoReservaRepository mongoRepository;

    @SuppressWarnings("rawtypes")
    public Reserva obtenerReserva(Long id, boolean usarMongo) {
        return usarMongo ? MongoRepository.findById(id).orElse(null) : ((ReactiveCrudRepository) mySQLRepository).findById(id).orElse(null);
    }
}
