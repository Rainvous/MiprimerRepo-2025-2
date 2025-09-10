using System;
using System.Collections.Generic;
namespace Pregunta2
{
	public class CancionBuilder
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
		//PROPIEDADES
        public string Titulo { get { return titulo; } set { titulo = value; } }
        public string Otrotitulo { get { return otrotitulo; } set { otrotitulo = value; } }
        public List<string> Interpretes { get { return interpretes; } set { interpretes = value; } }
        public List<string> Compositores { get { return compositores; } set { compositores = value; } }
        public Genero GeneroMusical { get { return generoMusical; } set { generoMusical = value; } }
        public string Album { get { return album; } set { album = value; } }
        public int Opus { get { return opus; } set { opus = value; } }
        public int Sub0pus { get { return sub0pus; } set { sub0pus = value; } }
        public string Dedicatoria { get { return dedicatoria; } set { dedicatoria = value; } }


		
		
		//CONSTRUCTORES
		public CancionBuilder(){
			compositores= new List<string>();
			interpretes = new List<string>();
		}
		//METODOS
		public CancionBuilder ConTitulo(string output){
			this.titulo=output;
			return this;
			
		}
		//NOTA COMO ENCADENAR FUNCIONES
		//tienes que ponerles de salida el mismo objeto pa encadenar 1 a 1
		public CancionBuilder TambienConocidaComo(string output){
			this.otrotitulo=output;
			return this;
			
		}
		public CancionBuilder InterpretadoPor(string output){
			interpretes.Add(output);
			return this;
		}
		public CancionBuilder CompuestoPor(string output){
			//Por buenas practicas la lista pasalo a otro objeto
			//no lo hago pq es string xd
			compositores.Add(output);
			return this;
		}
		public CancionBuilder DelGenero(Genero estGenero){
			this.generoMusical = estGenero;
			return this;
						
		}
		public CancionBuilder EnElAlbum(string output){
			this.album = output;
			return this;
			
		}
		public CancionBuilder IdentificadoConOpus(int output){
			this.opus = output;
			return this;
			
		}
		public CancionBuilder IdentificadoConSubOpus(int output){
			this.sub0pus = output;
			return this;
		}
		public CancionBuilder DedicadoA(string output){
			this.dedicatoria = output;
			return this;
		}
		public Cancion BuildCancion(){
			//Pense que estaba por las puras pero esta funcion es clave
			//:o
			Cancion cancionaux= new Cancion(this);
			return cancionaux;
		}
		
	}
	
}