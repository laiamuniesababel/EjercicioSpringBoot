package com.example.EjercicioSpringBoot.model;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.util.Date;

@lombok.Data
@Table(name = "operacion")
@Entity
public class Operacion {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "cantidad")
    private Double cantidad;

    @OneToOne
    @JoinColumn(name = "cuentaBancariaOrigen")
    private CuentaBancaria cuentaO;

    @OneToOne
    @JoinColumn(name = "cuentaBancariaDestino")
    private CuentaBancaria cuentaD;

}
