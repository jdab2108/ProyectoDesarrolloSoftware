package com.example.DlloSoftGrupo4.controlador;

import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Empresa;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@RequestMapping("/Empresa")
//@RestController

@Controller
public class ControladorEmpresa {

    @Autowired
    private ServicioEmpresa emp;

//  @GetMapping
//   public List<Empresa> listar(){
//       return emp.ListarEmpresa();}

//   @PostMapping
//    public Empresa insertar(@RequestBody Empresa empresa){
//        return emp.guardarEmpresas(empresa);
//    }

//    @PutMapping("/{nit}")
//    public Empresa actualizar(@RequestBody Empresa empresa){
//        return emp.actualizarEmpresas(empresa);
//    }
//
//    @DeleteMapping("/{nit}")
//    public void eliminarPorNit(@PathVariable("nit") Empresa empresa){
//        emp.eliminarEmpresasporId(empresa.getNit());
//    }

//    @PatchMapping("/{nit}")
//    public Empresa actualizarPorNit(@PathVariable("nit") Integer nit, @RequestBody Map<Object, Object> objectMap){
//        return emp.actualizarPorId(nit,objectMap);
//    }

//    @GetMapping("/{nit}")
//   public Empresa consultarPorNit(@PathVariable("nit") Integer nit){
//       return emp.consultarEmpresaPorId(nit);

//    }
// controlador para obtener la tabla Empresa en la interfaz
    @GetMapping("/Empresa")
        public String listarEmpresas(Model modelo){
        modelo.addAttribute("Empresa",emp.ListarEmpresa());
       return ("tablaempresas");
    }

    // controlador para registrar un nuevo movimiento de dinero con el formulario

    @GetMapping("Empresa/nuevo")
         public String formularioregistroempresa(Model modelo){
        modelo.addAttribute("empresainsertar", new Empresa());
        return ("frmnuevaempresa");
    }

    @PostMapping("Empresa/guardar")
    public String insertar(Empresa empresa){
        emp.guardarEmpresas(empresa);
        return ("redirect:/Empresa");
    }
    // controlador para actualizar la tabla con la empresa creada

    @GetMapping("Empresa/actualizar/{nit}")
    public String formularioActualizar (@PathVariable("nit")Integer nit, Model modelo){
        Empresa empresa=emp.consultarEmpresaPorId(nit);
        modelo.addAttribute("empresaactualizar", empresa);
        return ("frmactualizarempresa");
    }


    @PostMapping("Empresa/actualizar")
    public String actualizar(Empresa empresa) {
        emp.actualizarEmpresas(empresa);
        return ("redirect:/Empresa");

    }

    // controlador para eliminar empresa

    @GetMapping("Empresa/eliminar/{nit}")
    public String eliminar(@PathVariable("nit") Integer nit){
        emp.eliminarEmpresasporId(nit);
        return("redirect:/Empresa");



    }
}
