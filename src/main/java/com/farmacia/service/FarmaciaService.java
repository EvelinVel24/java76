package main.java.com.farmacia.service;

import org.springframework.stereotype.Service;
import com.farmacia.model.Farmacia;
import com.farmacia.repository.FarmaciaRepository;
import java.util.List;

@Service
public class FarmaciaService {
    private final FarmaciaRepository farmaciaRepository;

    public FarmaciaService(FarmaciaRepository farmaciaRepository) {
        this.farmaciaRepository = farmaciaRepository;
    }

    public List<Farmacia> listarMedicamentos() {
        return farmaciaRepository.findAll();
    }

    public Farmacia agregarMedicamento(String nombreMedicamento, double precio) {
        Farmacia farmacia = new Farmacia();
        farmacia.setNombreMedicamento(nombreMedicamento);
        farmacia.setPrecio(precio);
        return farmaciaRepository.save(farmacia);
    }
}
