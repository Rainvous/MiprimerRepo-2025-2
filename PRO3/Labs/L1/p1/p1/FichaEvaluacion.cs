using System;
//using es un package
namespace Pregunta1

{
	public class FichaEvaluacion
	{
		private Postulante candidato;
		private DateTime fecha_hora;
		private int evaluacion_expediente;
		private int evaluacion_entrevista;
		private int evaluacion_examen;
		private EstadoCandidato estado_candidato = EstadoCandidato.SIN_EVALUACION;
		//public FichaEvaluacion(Postulante candidato, DateTime fecha_hora, int evaluacion_entrevista, int evaluacion_expediente,
		//int evaluacion_examen,EstadoCandidato estado_candidato);
		//private static final Integer PUNTAJE_MINIMO_ADMISION=75;-> en java
		private const int PUNTAJE_MINIMO_ADMISION=75;
		public FichaEvaluacion(){}

		public FichaEvaluacion(FichaEvaluacion other)
		{
			this.candidato = (other.candidato != null) ? new Postulante(other.candidato) : null;
			//aqui se me salia la data null pero ya lo arregle akjsdkja
			this.fecha_hora = other.fecha_hora;
			this.evaluacion_entrevista = other.evaluacion_entrevista;
			this.evaluacion_examen = other.evaluacion_examen;
			this.evaluacion_expediente = other.evaluacion_expediente;
			this.estado_candidato = other.estado_candidato;
		}

		public Postulante Candidato
		{
			get {return candidato;}
			set {candidato = value;}
		}
		public EstadoCandidato Estado_candidato
		{
			get {
				int total = evaluacion_expediente+evaluacion_entrevista+evaluacion_examen;
				estado_candidato = (total>PUNTAJE_MINIMO_ADMISION) ? 
					estado_candidato=EstadoCandidato.ADMITIDO : estado_candidato=EstadoCandidato.NO_ADMITIDO;
				return estado_candidato;
				}
			set {estado_candidato = value;}
		}
		public DateTime Fecha_hora
				{
			get {return fecha_hora;}
			set {fecha_hora = value;}
		}
		public int Evaluacion_expediente
		{
			get {return evaluacion_expediente;}
			set {evaluacion_expediente = value;}
		}
		public int Evaluacion_entrevista
		{
			get {return evaluacion_entrevista;}
			set {evaluacion_entrevista = value;}
		}
		public int Evaluacion_examen
		{
			get {return evaluacion_examen;}
			set {evaluacion_examen = value;}
		}
	}
}