@ExtendWith(MockitoExtension.class)
public class ReservaServiceTests {
    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaService reservaService;

    @Test
    public void testCrearReserva() {
        Reserva reserva = new Reserva();
        when(reservaRepository.save(reserva)).thenReturn(reserva);
        Reserva result = reservaService.crearReserva(reserva);
        assertEquals(reserva, result);
    }
}
