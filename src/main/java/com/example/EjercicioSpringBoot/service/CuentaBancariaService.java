package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;
import com.example.EjercicioSpringBoot.repository.CuentaBancariaRepository;
import com.example.EjercicioSpringBoot.repository.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuentaBancariaService implements ICuentaBancariaService{

    private CuentaBancariaRepository cuentaRepository;

    @Autowired
    public CuentaBancariaService(CuentaBancariaRepository cuentaBancariaRepository) {
        this.cuentaRepository = cuentaBancariaRepository;
    }

    public List<CuentaBancaria> listarCuentas(){
        return cuentaRepository.findAll();
    }

    public CuentaBancaria crearCuentaBancaria(CuentaBancaria cuentaBancaria){
        return (CuentaBancaria) cuentaRepository.save(cuentaBancaria);
    }

    public void realizarIngreso(String iban, double cantidad) throws Throwable {
        CuentaBancaria cuenta = (CuentaBancaria) cuentaRepository.findById(iban).orElseThrow(() -> new RuntimeException("Cuenta bancaria no encontrada"));;
        cuenta.setCantidad(cuenta.getCantidad() + cantidad);
        cuentaRepository.save(cuenta);
    }

    public void realizarRetirada(String iban, double cantidad) throws Throwable{
        CuentaBancaria cuenta = (CuentaBancaria) cuentaRepository.findById(iban).orElseThrow(() -> new RuntimeException("Cuenta bancaria no encontrada"));
        cuenta.setCantidad(cuenta.getCantidad() - cantidad);
        cuentaRepository.save(cuenta);
    }
}
