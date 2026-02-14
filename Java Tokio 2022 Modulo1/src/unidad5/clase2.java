package unidad5;

public class clase2 {

	public static void main(String[] args) {
		Estudiante est= new Estudiante("Luis", 25, "657123456");
		System.out.println(est);
		est.setCurso("Programacion Java"); //Con esto podemos asignar un nuevo curso 
		System.out.println(est);
		est.comentarios[0]="Inicio del curso";   //Como el array es publico podemos asignarle un valor
		System.out.println(est.comentarios[0]);

	}

}
