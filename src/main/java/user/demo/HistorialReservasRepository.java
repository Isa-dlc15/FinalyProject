package user.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

@SuppressWarnings("rawtypes")
public interface HistorialReservasRepository extends MongoRepository<HistorialReservas, String> {
}
