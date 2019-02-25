package bean;

import java.beans.*;


public class ConexionUniversalBDBeanInfo extends SimpleBeanInfo{
	private static final Class<ConexionUniversalBD> ConexionUniversalBD = ConexionUniversalBD.class;

	ConexionUniversalBDBeanInfo(){
		super();
	}
	
	public PropertyDescriptor[] getPropertyDescriptors() {
		PropertyDescriptor properties[] = null;
		try {
			 // Create the array
		    properties = new PropertyDescriptor[5];
		    // Set property 1
		    properties[0] = new PropertyDescriptor("driver" ,ConexionUniversalBD);
		    properties[0].setConstrained(false);
		    properties[0].setDisplayName("Driver");
		    properties[0].setShortDescription("Driver de la Base de Datos");
		    // Set property 2
		    properties[1] = new PropertyDescriptor("url" ,ConexionUniversalBD);
		    properties[1].setConstrained(false);
		    properties[1].setDisplayName("URL");
		    properties[1].setShortDescription("URL de la Base de Datos");
		    // Set property 3
		    properties[2] = new PropertyDescriptor("nombBD" ,ConexionUniversalBD);
		    properties[2].setConstrained(false);
		    properties[2].setDisplayName("Nombre BD");
		    properties[3].setShortDescription("Nombre de la Base de Datos");
		    // Set property 4
		    properties[3] = new PropertyDescriptor("usuario" ,ConexionUniversalBD);
		    properties[3].setConstrained(false);
		    properties[3].setDisplayName("Usuario de la BD");
		    properties[3].setShortDescription("Usuario de la Base de Datos");
		    // Set property 5
		    properties[4] = new PropertyDescriptor("contrasenna" ,ConexionUniversalBD);
		    properties[4].setConstrained(false);
		    properties[4].setDisplayName("Contrasenna");
		    properties[4].setShortDescription("Contrasenna de la Base de Datos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return properties;
	}
	
	public EventSetDescriptor[] getEventSetDescriptors()
	{
		try {
	        EventSetDescriptor dial = new EventSetDescriptor(
	        		ConexionUniversalBD, "dialAdjusted",
	        		ConexionUniversalBD, "dialAdjusted");
	        dial.setDisplayName("Dial Adjusted");

	        return new EventSetDescriptor[] { dial };
	      }
	      catch (IntrospectionException e) {
	        return null;
	      }
	}
	
}
