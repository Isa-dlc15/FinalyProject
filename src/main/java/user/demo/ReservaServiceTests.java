package user.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
public class ReservaServiceTests {
    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void testCrearReserva() {
        Reserva reserva = new Reserva();
        when(ReactiveCrudRepository.save(reserva)).thenReturn(reserva);
        Reserva result = reservaService.crearReserva(reserva);
        assertEquals(reserva, result);
    }

    private OngoingStubbing<Mono> when(Mono save) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'when'");
    }

    private void assertEquals(Reserva reserva, Reserva result) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }
}
