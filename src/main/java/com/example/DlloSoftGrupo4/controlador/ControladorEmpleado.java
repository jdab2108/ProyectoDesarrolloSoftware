package com.example.DlloSoftGrupo4.controlador;


import com.example.DlloSoftGrupo4.entidades.Empleado;
import com.example.DlloSoftGrupo4.entidades.Usuario;
import com.example.DlloSoftGrupo4.servicios.ServicioEmpleado;
import com.example.DlloSoftGrupo4.servicios.ServicioUsuario;
import com.example.DlloSoftGrupo4.servicios.ServiciosImpEmpleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.PrinterGraphics;
import java.util.List;
import java.util.Map;

//@RequestMapping("/Empleado")
//@RestController

@Controller
public class ControladorEmpleado {


    @Autowired
    private ServicioEmpleado empl;

    @Autowired
    private ServicioUsuario servicioUsuario;

//   @GetMapping
//  public List<Empleado> listar()  {
//        return empl.listarEmpleados();
//    }
//    @GetMapping("/{id}")
//   public Empleado consultarPorcedula(@PathVariable("documentoEmpleado") Integer documentoEmpleado){
//       return empl.consultarEmpleadosid(documentoEmpleado);
//  }

//    @PostMapping
//    public Empleado insertar(@RequestBody Empleado empleado ){
//        return  empl.guardarEmpleados(empleado);
//    }


//    @PutMapping
//    public Empleado actualizar(@RequestBody Empleado empleado) {
//        return empl.actualizarEmpleados(empleado);
//    }

//    @DeleteMapping("/{id}")
 //   public String eliminarporId(@PathVariable("documentoEmpleado") Integer documentoEmpleado){
//        boolean respuesta= empl.eliminarEmpleados(documentoEmpleado);

//        if (respuesta){
//            return "Se eliminó el empleado"+documentoEmpleado+"con éxito";
//        }else{
//            return "No se pudo eliminar correctamente el empleado"+documentoEmpleado;
//        }

//    }



//    @PatchMapping("/Empleado/{id}")
//    public Empleado actualizarpor(@PathVariable("documentoempleado") Integer documentoEmpleado, @RequestBody Map<Object,Object> objectMap){
//        return empl.actualizarPorId(documentoEmpleado,objectMap);
//    }

    //  controlador para registrar un nuevo movimiento de dinero con el formulario

   @GetMapping("/Empleado")
       public String listarEmpleados(Model modelo){
       modelo.addAttribute("Empleado",empl.listarEmpleados());
        return("tablaempleado");
    }

    // controlador para registrar un nuevo Empleado de dinero con el formulario

    @GetMapping("Empleado/nuevo")
        public String formualrioregistroempleado(Model modelo){
        modelo.addAttribute("empleadoinsertar",new Empleado());
        return "frmnuevoempleado";
    }
    // controlador para actualizar la tabla con el empleado creado
    @PostMapping("Empleado/guardar")
        public String insertar(Empleado empleado){
        empl.guardarEmpleados(empleado);
        return "redirect:/Empleado";
    }
// Controladores para actualizar empleado

    @GetMapping("Empleado/actualizar/{documentoEmpleado}")
        public String frmactualizar(@PathVariable("documentoEmpleado") Integer documentoEmpleado, Model modelo){
        Empleado empleado = empl.consultarEmpleadosid(documentoEmpleado);
        modelo.addAttribute("empleadoactualizar",empleado);
        return "frmactualizarempleado";
    }

    @PostMapping("Empleado/actualizar")
        public String actualizar(Empleado empleado){
        empl.actualizarEmpleados(empleado);
        return"redirect:/Empleado";
    }

// controlador para eliminar un empleado

    @GetMapping("Empleado/eliminar/{documentoEmpleado}")
        public String eliminar(@PathVariable("documentoEmpleado")Integer documentoEmpleado){
        empl.eliminarEmpleados(documentoEmpleado);
        return ("redirect:/Empleado");
    }

    public ControladorEmpleado(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal OidcUser principal) {
       if(principal !=null) {

           Usuario usuario=this.servicioUsuario.obtenerUsuario(principal.getClaims());
           System.out.print(principal.getClaims());
           model.addAttribute("usuario",usuario);
       }
        return "index";
    }


}
