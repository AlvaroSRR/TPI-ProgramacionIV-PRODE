// package com.ProgIV.Prode.features.services.impl.prediccion;

// import java.util.List;

// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Service;

// import com.ProgIV.Prode.features.models.EstadoPartido;
// import com.ProgIV.Prode.features.models.Partido;
// import com.ProgIV.Prode.features.repositories.PartidoRepository;

// import lombok.RequiredArgsConstructor;

// @Service
// @RequiredArgsConstructor
// public class PuntosScheduler {

//     private final PartidoRepository partidoRepository;
//     private final CalcularPuntosService calcularPuntosService;


//     @Scheduled(fixedRate = 60000) // cada 60 segundos
//     public void calcularPuntosPartidosFinalizados() {

//         List<Partido> partidos = partidoRepository
//                 .findByEstadoPartido(EstadoPartido.FINALIZADO);


//         for (Partido partido : partidos) {

//             calcularPuntosService.calcularPuntos(partido);

//         }
//     }
// }