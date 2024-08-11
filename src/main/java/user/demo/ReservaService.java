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

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
    private final MySQLReservaRepository mySQLRepository;
    private final MongoReservaRepository mongoRepository;

    public Reserva obtenerReserva(Long id, boolean usarMongo) {
        return usarMongo ? mongoRepository.findById(id).orElse(null) : mySQLRepository.findById(id).orElse(null);
    }
}
