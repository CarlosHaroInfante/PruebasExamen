package edu.Servicios;

import java.util.List;

import edu.Dtos.Citas;

public interface OperativaInterfaz {

	public void CitasNueva(List<Citas> listaCitas);
	
	public void registroLlegada(List<Citas> listaCitas);
	
	public void listadoConsultas(List<Citas> listaCitas);
}
