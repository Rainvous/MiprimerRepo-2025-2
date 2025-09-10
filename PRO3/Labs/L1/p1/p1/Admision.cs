using System;
using System.Collections.Generic; //lista
using System.Text;
//por buenas practicas solo pon los que usarás

namespace Pregunta1
{
	public class Admision
	{
		private List<FichaEvaluacion> listaFichas;
		private int cantidad_admitidos;
		private int cantidad_postulantes;
		
		
		public Admision(){
			listaFichas = new List<FichaEvaluacion>();
			this.cantidad_admitidos=0;
			this.cantidad_postulantes=0;//por orden
			
			
		}
		
		
		
		public void agregarFichaDeEvaluacion(FichaEvaluacion ficha){
			
			if(ficha ==null) return;
			FichaEvaluacion copia =new FichaEvaluacion(ficha);
			
			EstadoCandidato estado = copia.Estado_candidato; //aqui modificamo el get en propiedades
			//pa que retorne el estado
			
			cantidad_postulantes++;
			if( estado == EstadoCandidato.ADMITIDO)
			{
				cantidad_admitidos++;
			}
			listaFichas.Add(copia);
			
		}
		
		public override string ToString()
		{
			StringBuilder sb = new StringBuilder();
			sb.AppendFormat("PROCESO DE ADMISION: {0} postulantes, {1} admitidos ",cantidad_postulantes,cantidad_admitidos);
			sb.AppendLine();
			sb.AppendLine("LISTA DE ADMITIDOS: "); //automaticamente dsp pone cambio de linea
			foreach (var f in listaFichas)
			{
				if(f.Estado_candidato == EstadoCandidato.ADMITIDO && f.Candidato!= null)
				{
					sb.AppendLine(f.Candidato.ToString()); //el string builder siempre debe recibir un string por eso el ToString que 
					//le pusimos override
				}
			}
			return sb.ToString();
		}
	}
	
}