package prueba.tecnica.CRUD.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T01_SOLICITUD")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ESTADO")
    private int estado;

    @Column(name = "FECHA_INGRESO")
    private Date fecha_ingreso;

    @Column(name = "MONTO")
    private double monto;

    @Column(name = "ID_CLIENTE")
    private String id_cliente;
}
