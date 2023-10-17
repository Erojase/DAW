package es.joyfe.daw.des.main;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.joyfe.daw.des.oficina.OficinaAtencionCliente;

public class MainSpringWithApplicationContext {

        public static void main(String[] args) {
                
                try {
                        @SuppressWarnings("resource")
                        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
                        
                        OficinaAtencionCliente oficina = (OficinaAtencionCliente) context.getBean("oficinaAttCliente");
                        
                        oficina.envioUrgente("to:urgen: Cancelar Pedido");
                } catch (BeansException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                
        }

}
