import javax.swing.JOptionPane;

public class Division {
	
	public static int divisionEntera(int numerador, int denominador){
		return numerador / denominador;
	}

	public static void main(String[] args){
		try{
			int num=Integer.parseInt(JOptionPane.showInputDialog("Escribe el numerador"));
			int den=Integer.parseInt(JOptionPane.showInputDialog("Escribe el denominador"));
			if(den == 0){
				throw new IllegalArgumentException("No se puede dividir entre 0"); 
			}
			else if(den > 0 || den < 0){
				JOptionPane.showMessageDialog(null, "El resultado de dividir "+num+"/"+den+" es "+divisionEntera(num,den));	
			}
			else{
				throw new NumberFormatException("Favor de insertar un numero y no una letra");
			}
		}
		catch(IllegalArgumentException e){ // java.lang.IllegalArgumentException: por dividir entre 0 
			System.out.println("Ocurrio un error "+e);
		} 
		catch(NumberFormatException e){
			System.out.println("Ocurrio un error en " +e);
		}
	}
	//Ctrl+A = Seleccionar todo Ctrl+I=Indent all
	//Subir antes del jueves si el usuario pone algun dato invalido que mande una excepci�n (Tal como div 0 o String)
	// java.lang.NumberFormatException: error por un String
}
