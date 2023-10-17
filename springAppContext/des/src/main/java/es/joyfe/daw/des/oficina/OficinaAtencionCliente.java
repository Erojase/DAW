package es.joyfe.daw.des.oficina;

import java.util.ArrayList;
import java.util.List;

import es.joyfe.daw.des.servicio.ServicioComunicacion;

public class OficinaAtencionCliente {
        
        ServicioComunicacion servicio = null;
        
        public OficinaAtencionCliente(ServicioComunicacion servicioComunicacion) {
                servicio = servicioComunicacion;
        }
        
        
        /*
         * En este caso estamos "inyectando" a la clase el Servicio de comunicaciones,
         * la oficina no se tiene que preocupar por el servicio a utilizar. El contenedor
         * es el encargado de decidir que servicio utilizar
         */
        //ServicioComunicacion servicio = null;
        
        // Inyecci�n de dependencias mediante uso del m�todo set (por "setter")
        public void setServicioComunicacion(ServicioComunicacion servicioComunicacion){
                this.servicio = servicioComunicacion;
        }
                        
        List<String> mensajes = new ArrayList<String>();
        
        
        
        public void envioUrgente(String mensaje){
                servicio.enviar(mensaje);
        }
        
        public void envioNormal(String mensaje){
                mensajes.add(mensaje);
                if(mensajes.size()>0){
                        enviarTodo();
                }
        }
        
        public void enviarTodo(){
                for(String mensajesAEnviar:mensajes){
                        servicio.enviar(mensajesAEnviar);
                }
                mensajes = new ArrayList<String>();
        }
}