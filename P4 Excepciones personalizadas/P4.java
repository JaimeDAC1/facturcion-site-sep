
public class P4 {

	public static void main(String[] args) {
		EdadException mayorDeEdad = new EdadException();
        try{
        	mayorDeEdad.validarEdad(17);
        } catch(EdadException ex){
           // System.out.println("Se ejecuto la ex personalizada");
           // ex.printStackTrace();
           System.out.println("Se ejecuto la ex personalizada " + ex.getMessage());
        } catch(Exception ex){
            System.out.println("Exception por default");
        }
    }
}


	