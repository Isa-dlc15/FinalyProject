package user.demo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("hiding")
@Document(collection = "historial_reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialReservas<reservas> {
    @Id
    private String id;
    private String usuarioId;
    private List<Reserva> reservas;
}
