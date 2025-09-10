import java.util.Date;
class ExamenDiagnostico extends AtencionMedica{
	private SalaEspecializada salaEspecializada;
	private TipoExamen tipoExamen;
	public ExamenDiagnostico(Paciente paciente, Medico medico, Date fechaHoraAtencion, SalaEspecializada salaEspecializada, TipoExamen tipoExamen){
		super(paciente, medico, fechaHoraAtencion);
		setTipoAtencion(TipoAtencion.EXAMEN_DIAGNOSTICO);
		this.salaEspecializada = salaEspecializada;
		this.tipoExamen = tipoExamen;
	}
	@Override
	public String consultarDatos(){
		return super.datosCabecera() + salaEspecializada.devolverInformacion() + "TIPO EXAMEN:" + tipoExamen + "\n";
	}
}