package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;
import com.example.EjercicioSpringBoot.model.Operacion;
import com.example.EjercicioSpringBoot.repository.CuentaBancariaRepository;
import com.example.EjercicioSpringBoot.repository.OperacionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InicializacionService implements IInicializacionService{
    @Autowired
    private CuentaBancariaRepository cuentaBancaria;
    @Autowired
    private OperacionRepository operacion;

    @Autowired
    public InicializacionService(CuentaBancariaRepository cuentaBancariaRepository,
                                 OperacionRepository operacionRepository) {
        this.cuentaBancaria = cuentaBancariaRepository;
        this.operacion = operacionRepository;
    }

    @PostConstruct
    public void inicializar(){
        CuentaBancaria cuenta = new CuentaBancaria();
        cuentaBancaria.save(cuenta);

        Operacion operacion1 = new Operacion();
        operacion1.setCuentaO(cuenta);
        operacion.save(operacion1);

        Operacion operacion2 = new Operacion();
        operacion2.setCuentaO(cuenta);
        operacion.save(operacion2);

    }
}
