package com.example.EjercicioSpringBoot.repository;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaBancariaRepository extends JpaRepository<CuentaBancaria, String> {
}
