package com.example.EjercicioSpringBoot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "cuentaBancaria")
@Entity
public class CuentaBancaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iban")
    private String iban;

    @Column(name = "cantidad")
    private double cantidad;

    @Column(name = "idEntidad")
    private int idEntidad;

}
