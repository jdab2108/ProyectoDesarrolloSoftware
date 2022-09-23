package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Empresa;
import com.example.DlloSoftGrupo4.entidades.MovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpresa;
import com.example.DlloSoftGrupo4.servicios.ServicioMovimientoDinero;
import com.example.DlloSoftGrupo4.servicios.ServiciosImpMovimientoDinero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//@RequestMapping("/Empresa")
//@RestController
@Controller
public class ControladorMovimientoDinero {


    @Autowired
    private ServicioMovimientoDinero smd;

//    @GetMapping("/MovimientoDinero/all")
//   public List<MovimientoDinero> listar()  {
//        return smd.listarMovimientoDinero();
//    }

//    @GetMapping ("/{codigo}/MovimientoDinero")
    //       public MovimientoDinero consultarMovimientoporNit(@PathVariable("codigo") Integer codigo){
    //       return smd.consultarMovimientosPorID(codigo);
    //   }


    //   @PostMapping("/MovimientoDinero")
    //   public MovimientoDinero insertar(@RequestBody MovimientoDinero movDinero ){
    //       return  smd.guardarMovimientos(movDinero);
//    }


//    @PutMapping("/MovimientoDinero")
//    public MovimientoDinero actualizar(@RequestBody MovimientoDinero movDinero) {
//        return smd.actualizarMovimientos(movDinero);
//    }

//    @DeleteMapping("/{codigo}/MovimientoDinero")
//    public void eliminarporId(@PathVariable("codigo") Integer codigo){
//        smd.eliminarMovimientos(codigo);

//    }

//    @PatchMapping("/{codigo}/MovimientoDinero")
//    public MovimientoDinero actualizarpor(@PathVariable("codigo") Integer codigo, @RequestBody Map<Object,Object> objectMap){
//        return smd.actualizarporID(codigo,objectMap);
//    }

    // consulta de movimiento dinero con nit y movimientoDinero
//    @GetMapping("/{nit}/MovimientoDinero")
    //   public ArrayList<MovimientoDinero> movimientosPorEmpresa(@PathVariable("nit") Integer nit){
    //       return  smd.obtenerPorEmpresa(nit);
    //   }


    // controlador para obtener la tabla Empleado en la interfaz
    @GetMapping("/MovimientoDinero")
    public String listarmovimientos(Model modelo) {
        modelo.addAttribute("MovimientoDinero", smd.listarMovimientoDinero());
        return ("tablaingresosyegresos");
    }

    // controlador para registrar un nuevo movimiento de dinero con el formulario

    @GetMapping("MovimientoDinero/nuevo")
    public String formualrioregistromovimientos(Model modelo) {
        modelo.addAttribute("movimientosinsertar", new MovimientoDinero());
        return ("frmnuevomovdinero");
    }

    // controlador para actualizar la tabla con el movimiento creado
    @PostMapping("MovimientoDinero/guardar")
    public String movimientosinsertar(MovimientoDinero movDinero) {
        smd.guardarMovimientos(movDinero);
        return "redirect:/MovimientoDinero";
    }

// Controladores para actualizar movimientos

    @GetMapping("MovimientoDinero/actualizar/{codigo}")
    public String formularioActualizar(@PathVariable("codigo") Integer codigo, Model modelo) {
        MovimientoDinero movDinero = smd.consultarMovimientosPorID(codigo);
        modelo.addAttribute("movimientosactualizar", movDinero);
        return "frmactualizarmovdinero";
    }

    @PostMapping("MovimientoDinero/actualizar")
    public String actualizar(MovimientoDinero movDinero) {
        smd.actualizarMovimientos(movDinero);
        return "redirect:/MovimientoDinero";
    }

// controlador para eliminar un movimiento de dinero

    @GetMapping("MovimientoDinero/eliminar/{codigo}")
    public String eliminar(@PathVariable("codigo") Integer codigo, RedirectAttributes redirectAttrs) {
        redirectAttrs
                .addFlashAttribute("mensaje", "Eliminado correctamente")
                .addFlashAttribute("clase", "warning");

        smd.eliminarMovimientos(codigo);
        return ("redirect:/MovimientoDinero");
    }
}