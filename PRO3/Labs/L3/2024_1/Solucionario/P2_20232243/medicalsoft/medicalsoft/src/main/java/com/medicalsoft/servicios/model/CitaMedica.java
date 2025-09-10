package com.medicalsoft.servicios.model;

import com.medicalsoft.rrhh.model.AtencionMedica;
import com.medicalsoft.rrhh.model.Medico;
import com.medicalsoft.rrhh.model.Paciente;
import com.medicalsoft.rrhh.model.TipoAtencion;
import java.util.Date;
abstract public class CitaMedica extends AtencionMedica{
	private String motivoCitaMedica;
	public CitaMedica(Paciente paciente, Medico medico, Date fechaHoraAtencion, String motivoCitaMedica){
		super(paciente, medico, fechaHoraAtencion);
		setTipoAtencion(TipoAtencion.CITA_MEDICA);
		this.motivoCitaMedica = motivoCitaMedica;
	}
	@Override
	public abstract String consultarDatos();
	@Override
	public String datosCabecera(){
		return super.datosCabecera();
	}
}