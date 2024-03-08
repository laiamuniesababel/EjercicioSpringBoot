package com.example.EjercicioSpringBoot.repository;

import com.example.EjercicioSpringBoot.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacionRepository extends JpaRepository<Operacion, Integer> {
}
