package es.joyfe.daw.des.servicio;

public class ServicioComunicacionCorreoElectronico implements ServicioComunicacion {

        @Override
        public void enviar(String mensaje) {
                System.out.println("Enviando mensaje por correo electronico: " + mensaje);
        }

}