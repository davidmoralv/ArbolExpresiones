import java.util.Scanner;

public class ArbolExpresiones {

	static String[] expresionArray;
	static String[] pr;
	static String[] reduc;
	static String[] ven;
	int x, y = -1;

	public ArbolExpresiones() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Digite la expresión aritmética (Operandos entre 1 y 9)");
		Scanner sc = new Scanner(System.in);
		String expresion = sc.nextLine();
		sc.close();
		expresionArray = expresion.split("");

		int x = retornarPosicionParentesisIzq(expresionArray);
		int y = retornarPosicionParentesisDer(expresionArray);

		for (int i = 0; i < expresionArray.length; i++) {
			pr[i] = expresionArray[i];
		}

		int w = 0;
		if (pr[0] != "(") {
			for (int i = 0; i < pr.length; i++) {
				reduc[w] = pr[i];
				if ((i < x) || (i > y)) {
					w = w + 1;
				}
			}
		}

		if (pr[0] == "(") {
			for (int i = y + 1; i < pr.length; i++) {
				reduc[w] = pr[i];
				w = w + 1;
			}
		}
		
		int v = 0;
		for (int i = 0; i < pr.length; i++) {
			if ((i >= x) && (i <= y)) {
				ven[v] = pr[i];
				v = v + 1;
			}
		}
		
		int acum=0;
		for(int i = 0; i< )
		
		
		
		

	}

	static int retornarPosicionParentesisIzq(String[] expresion) {
		for (int i = 0; i < expresion.length; i++) {
			if (expresion[i] == "(" && expresion[i + 1] != "(") {
				return i;
			}
		}
		return -1;
	}

	static int retornarPosicionParentesisDer(String[] expresion) {
		for (int i = 0; i < expresion.length; i++) {
			if (expresion[i] == ")" && expresion[i + 1] != ")") {
				return i;
			}
		}
		return -1;
	}

}
