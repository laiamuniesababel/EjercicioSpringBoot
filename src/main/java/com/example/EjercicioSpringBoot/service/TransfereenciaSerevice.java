package com.example.EjercicioSpringBoot.service;

import com.example.EjercicioSpringBoot.model.CuentaBancaria;
import com.example.EjercicioSpringBoot.model.Operacion;
import com.example.EjercicioSpringBoot.repository.CuentaBancariaRepository;
import com.example.EjercicioSpringBoot.repository.OperacionRepository;

import javax.xml.crypto.Data;
import java.util.Date;

public class TransfereenciaSerevice implements ITransferenicaService{
    private CuentaBancariaRepository cuentaRepository;
    private OperacionRepository operacionRepository;

    public void realizarTransferencia(String ibanO, String ibanD, double cantidad) throws Throwable {
        CuentaBancaria cuentaO = (CuentaBancaria) cuentaRepository.findById(ibanO).orElseThrow(() -> new RuntimeException("Cuenta bancaria no encontrada"));;
        CuentaBancaria cuentaD = (CuentaBancaria) cuentaRepository.findById(ibanD).orElseThrow(() -> new RuntimeException("Cuenta bancaria no encontrada"));;

        boolean entidad = comprovarEntidad(cuentaO, cuentaD);

        if(entidad){
            transfrenciaMismaEntidad(cuentaO, cuentaD, cantidad);
        }else {
            transferenciaDiferenteEntidad(cuentaO, cuentaD, cantidad);
        }
    }

    private boolean comprovarEntidad(CuentaBancaria cuenta1, CuentaBancaria cuenta2){
        return cuenta1.getIdEntidad() == cuenta2.getIdEntidad();
    }

    private void transfrenciaMismaEntidad(CuentaBancaria cuentaO, CuentaBancaria cuentaD, double cantidad){
        cuentaO.setCantidad(cuentaO.getCantidad() - cantidad);
        cuentaD.setCantidad(cuentaD.getCantidad() + cantidad);
        cuentaRepository.save(cuentaO);
        cuentaRepository.save(cuentaD);

        Operacion operacion = new Operacion();
        operacion.setCuentaO(cuentaO);
        operacion.setCuentaD(cuentaD);
        operacion.setFecha((Data) new Date());
        operacion.setCantidad(cantidad);
        operacionRepository.save(operacion);
    }

    private void transferenciaDiferenteEntidad(CuentaBancaria cuentaO, CuentaBancaria cuentaD, double cantidad){
        cuentaO.setCantidad(cuentaO.getCantidad() - cantidad - 3.99);
        cuentaD.setCantidad(cuentaD.getCantidad() + cantidad);
        cuentaRepository.save(cuentaO);
        cuentaRepository.save(cuentaD);

        Operacion operacion = new Operacion();
        operacion.setCuentaD(cuentaD);
        operacion.setCuentaO(cuentaO);
        operacion.setFecha((Data) new  Date());
        operacion.setCantidad(cantidad);
        operacionRepository.save(operacion);
    }
}
