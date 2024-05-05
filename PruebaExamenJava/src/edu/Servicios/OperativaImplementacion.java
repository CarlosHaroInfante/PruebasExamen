package edu.Servicios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import edu.Dtos.Citas;

public class OperativaImplementacion implements OperativaInterfaz{

	Scanner sc = new Scanner(System.in);
	public void CitasNueva(List<Citas> listaCitas) {
		try {
		Citas citasNuevas = new Citas();
		
		
		System.out.println("Pedir una cita nueva");
		
		System.out.println("Apellidos del paciente");
		citasNuevas.setApellidos(sc.nextLine());
		
		System.out.println("Nombre del paciente");
		citasNuevas.setNombre(sc.next());	
		
		System.out.println("DNI del paciente");
		citasNuevas.setDni(sc.next());
		
		System.out.println("Especialidad ([0] - Psicología [1] - traumatología [2] - fisioterapia)");
		int op = sc.nextInt();
		
		if(op == 0) {
			citasNuevas.setEspecialidad("Psicología");
		}
		else if(op == 1) {
			citasNuevas.setEspecialidad("traumatología");
		}
		else if(op == 2) {
			citasNuevas.setEspecialidad("fisioterapia");
		}
		else {
			System.out.println("opción no válida");
		}
	
		
		System.out.println("Fecha de  la cita(formato dd-MM-yyyy)");
		citasNuevas.setFechaCita(sc.next());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		
		System.out.println("Precio");
		citasNuevas.setPrecio(sc.nextDouble());
		
		citasNuevas.setIdCitas(idAuto(listaCitas));
		
		listaCitas.add(citasNuevas);
		
		for (Citas citas : listaCitas) {
			System.out.println(citas.toString());
		}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al añadir la cita" + e.getMessage());
		}
		
		
	}
	public void registroLlegada(List<Citas> listaCitas) {
		try {
		Citas dniCliente = new Citas();
		System.out.println("DNI del cliente con cita");
		String Dni = sc.next();
		
		LocalDate fechaHoy = LocalDate.now();
		
		int dia = fechaHoy.getDayOfMonth();
		int mes = fechaHoy.getMonthValue();
		int anyo = fechaHoy.getYear();
		
		String diaFin = String.valueOf(dia);
		String mesFin = String.valueOf(mes);
		String anyoFin = String.valueOf(anyo);
		
		String fechaFin = diaFin + "/" + mesFin + "/" + anyoFin;
		System.out.println(fechaFin);
		
		if(validarDni(Dni)) {
			
			System.out.println("El DNI es válido");
			
			for (Citas citas : listaCitas) {
				System.out.println(citas.toString());
				if(citas.getFechaCita().equals(fechaFin)) {
					System.out.println("Espere su turno para la consulta de Psicología en la sala de espera. Su especialista le avisará.");
				}
				else {
					System.out.println("No dispone de cita previa para hoy.");
				}
			}
		}
		else {
			System.out.println("El DNI no es válido");
		}
		
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al validar la cita");
		}
	}
		
	
	public void listadoConsultas(List<Citas> listaCitas) {
		
		try {
			
			System.out.println("Fecha de la consulta dd/MM/yyyy");
			String fecha = sc.next();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al listar las consultas");
		}
		
	}
	
	private long idAuto(List<Citas> listaCitas) {
		
		long idNuevo = 0;
		
		int tamanioLista = listaCitas.size();
		
		
		if(tamanioLista > 0) {
			
			idNuevo = listaCitas.get(tamanioLista - 1).getIdCitas() + 1;
		}
		
		else {
			idNuevo = 1;
		}
		
		return idNuevo;
	}
	
	private boolean validarDni(String Dni) {
		
		if(Dni.length() != 9) {
			return false;
		}
		
		String  numeroDni = Dni.substring(0, 8);
		
		char letra = Character.toUpperCase(Dni.charAt(8));
		String letrasValida = "TRWAGMYFPDXBNJZSQVHLCKE";
		int resto = Integer.parseInt(numeroDni) % 23;
		char letraCalculada = letrasValida.charAt(resto);
		
		return letra == letraCalculada;

	}
}
