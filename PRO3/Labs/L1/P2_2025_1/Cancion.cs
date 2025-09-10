using System;
using System.Collections.Generic;
using System.Text;//para build string
namespace Pregunta2
{
	
	public class Cancion
	{
		private string titulo;
		private string otrotitulo;
		private List<string> interpretes;
		private List<string>compositores;//lista compositores
		private Genero  generoMusical;
		private string album;
		private int opus;
		private int sub0pus;
		private string dedicatoria;
		//Constructores
		public Cancion(){
			compositores= new List<string>();
			
		}
		public Cancion(Cancion output){
			compositores= new List<string>(output.compositores);
			interpretes= new List<string>(output.interpretes);
			//copias tu lista compositores del 
			//output a este objeto (creando otra memoria (ver notion de lista c#))
			this.titulo= output.titulo;
			this.otrotitulo= output.otrotitulo;
			
			this.generoMusical=output.generoMusical;
			this.album=output.album;
			this.opus=output.opus;
			this.sub0pus= output.sub0pus;
			this.dedicatoria= output.dedicatoria;
			
			
		}
		
		//falta constructor cancion x cancionbuilder
		public Cancion(CancionBuilder builder){
			this.titulo = builder.Titulo;
			this.otrotitulo = builder.Otrotitulo;
			this.interpretes = new List<string>(builder.Interpretes);
			this.compositores = new List<string>(builder.Compositores);
			this.generoMusical = builder.GeneroMusical;
			this.album = builder.Album;
			this.opus = builder.Opus;
			this.sub0pus = builder.Sub0pus;
			this.dedicatoria = builder.Dedicatoria;
		}

		//Propiedades
		
		
	public override string ToString()
	{
		StringBuilder sb = new StringBuilder();

		if (!string.IsNullOrEmpty(titulo))
			sb.AppendFormat("TITULO: {0}\n", titulo);

		if (!string.IsNullOrEmpty(otrotitulo))
			sb.AppendFormat("TAMBIEN CONOCIDA COMO: {0}\n", otrotitulo);

		if (interpretes != null && interpretes.Count > 0)
			sb.AppendFormat("INTERPRETADO POR: {0}\n", string.Join(", ", interpretes));

		if (compositores != null && compositores.Count > 0)
			sb.AppendFormat("COMPUESTO POR: {0}\n", string.Join(", ", compositores));

		if (generoMusical == Genero.CLASICA || generoMusical == Genero.FOLKLORE)
			sb.AppendFormat("TIPO: {0}\n", generoMusical == Genero.CLASICA ? "CLASICA" : "FOLKLORE");

		if (!string.IsNullOrEmpty(album))
			sb.AppendFormat("ALBUM: {0}\n", album);

		if (opus != 0)
			sb.AppendFormat("OPUS: {0}\n", opus);

		if (sub0pus != 0)
			sb.AppendFormat("SUBOPUS: {0}\n", sub0pus);

		if (!string.IsNullOrEmpty(dedicatoria))
			sb.AppendFormat("DEDICATORIA: {0}\n", dedicatoria);

		return sb.ToString();
	}

		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}