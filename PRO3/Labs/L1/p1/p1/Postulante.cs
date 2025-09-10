using System;
//using es un package
namespace Pregunta1

{
	public class Postulante{
		private string paterno;
		private string materno;
		private string nombre;
		private string dni;
		public Postulante(){
			
		}
		public Postulante(string paterno, string materno, string nombre, string dni){
			this.paterno = paterno;
			this.materno = materno;
			this.nombre = nombre;
			this.dni = dni;
		}
		public Postulante(Postulante other){
			if(other!=null){
				this.paterno = other.paterno;
				this.materno = other.materno;
				this.nombre = other.nombre;
				this.dni = other.dni;
			}
		}
		
		//propiedades
		public string Paterno
		{
			get {return paterno;}
			set {paterno = value;}
		}
		public string Materno
		{
			get {return materno;}
			set {materno = value;} //value: coje el valor y se lo asigna -> postulante.Paterno = "tustring"
		}
		public string Nombre
		{
			get {return nombre;}
			set {nombre = value;}
		}
		public string Dni
		{
			get {return dni;}
			set {dni = value;}
		}
		
		//metodos
		public override string ToString(){
			return string.Format("{0} {1}, {2} ({3})", paterno, materno, nombre, dni);//le pones la forma y agregas dsp los string
			//aqui puedes usar la propiedad o el atributo
		}
	}
	
}
