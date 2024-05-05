package edu.Controladores;

import java.util.ArrayList;
import java.util.List;

import edu.Dtos.Citas;
import edu.Servicios.MenuImplementacion;
import edu.Servicios.MenuInterfaz;
import edu.Servicios.OperativaImplementacion;
import edu.Servicios.OperativaInterfaz;

public class Inicio {

	public static void main(String[] args) {
		
		boolean cerrarMenu = false;
		
		List<Citas> citas = new ArrayList<Citas>();
		MenuInterfaz menu = new MenuImplementacion();
		OperativaInterfaz operativa = new OperativaImplementacion();
		
		while(!cerrarMenu) {
			
			int opcion = menu.menuAmbulatorio();
			
			switch (opcion) {
			case 0: {
				System.out.println("Cerrar Menú");
				cerrarMenu =  true;
				break;
				
			}
			case 1: {
				
				System.out.println("Pedir Citas");
				operativa.CitasNueva(citas);
				break;
			}
			case 2: {
				System.out.println("Registro de llegada");
				operativa.registroLlegada(citas);
				break;
			}
			case 3: {
				System.out.println("Listado de consultas");
				int opcion2 = menu.menuConsultas();
				switch (opcion2) {
				case 0: {
					System.out.println("Volver");
					menu.menuAmbulatorio();
					break;
				}
				case 1: {
					System.out.println("Mostrar consultas");
					int  opcion3 = menu.menuCitas();
					switch (opcion3) {
					case 0: {
						
						System.out.println("Psicología");
						break;
					}
					case 1: {
						System.out.println("Traumatología");
						break;
					}
					case 2: {
						System.out.println("Fisioterapia");
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + opcion3);
					}
					break;
				}
				case 2: {
					System.out.println("Imprimir consultas");
					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + opcion2);
				}
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcion);
			}
			
			
		}
		
		
	}
}
