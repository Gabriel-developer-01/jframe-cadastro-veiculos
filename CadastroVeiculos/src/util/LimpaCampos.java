package util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

public class LimpaCampos {

	public static void LimpaTela(Container container) {     
        //limpa os campos     
        for (int i=0; i < container.getComponentCount(); i++) {   
            //varre todos os componentes     
            Component c = container.getComponent(i);     
            if (c instanceof JTextField) {                           
                JTextField field = (JTextField) c;   
                field.setText("");                      
            }else if (c instanceof JFormattedTextField) {
            	JFormattedTextField field = (JFormattedTextField) c;  
            	field.setText("");
            }   
        }   
    }    
}
