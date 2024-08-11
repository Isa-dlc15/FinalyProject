@Document(collection = "historial_reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReservas {
    @Id
    private String id;
    private String usuarioId;
    private List<Reserva> reservas;
}
