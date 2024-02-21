package com.jdbc2.ejercicio;

import java.util.ArrayList;
import java.util.List;

import com.jdbc2.ejercicio.Database.DaoResources.DaoConstruccion;
import com.jdbc2.ejercicio.Database.DaoResources.DaoGranjero;
import com.jdbc2.ejercicio.Database.DaoResources.DaoPlantacion;
import com.jdbc2.ejercicio.Database.DaoResources.DaoRiego;
import com.jdbc2.ejercicio.Database.DaoResources.DaoTractor;
import com.jdbc2.ejercicio.Models.Construccion;
import com.jdbc2.ejercicio.Models.Granjero;
import com.jdbc2.ejercicio.Models.Plantacion;
import com.jdbc2.ejercicio.Models.Riego;
import com.jdbc2.ejercicio.Models.Tractor;

public class EjercicioApplication {

	private static List<Construccion> construcciones = new ArrayList<>();
	private static List<Granjero> granjeros = new ArrayList<>();
	private static List<Plantacion> plantaciones = new ArrayList<>();
	private static List<Riego> riegos = new ArrayList<>();
	private static List<Tractor> tractores = new ArrayList<>();

	public static void main(String[] args) {
		EntryPoint entry = new EntryPoint(args,
				construcciones,
				granjeros,
				plantaciones,
				riegos,
				tractores);

		DaoConstruccion daoConstruccion = new DaoConstruccion();
		DaoGranjero daoGranjero = new DaoGranjero();
		DaoPlantacion daoPlantacion = new DaoPlantacion();
		DaoRiego daoRiego = new DaoRiego();
		DaoTractor daoTractor = new DaoTractor();

		for (Construccion construct : construcciones) {
			daoConstruccion.insert(construct);
		}
		for (Granjero construct : granjeros) {
			daoGranjero.insert(construct);
		}
		for (Plantacion construct : plantaciones) {
			daoPlantacion.insert(construct);
		}
		for (Riego construct : riegos) {
			daoRiego.insert(construct);
		}
		for (Tractor construct : tractores) {
			daoTractor.insert(construct);
		}
	}

}