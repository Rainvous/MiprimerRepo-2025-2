using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBase.model
{
    public class VideojuegosDTO
    {
        private int idVideojuego;
        private string nombreVideojuego;
        private DateTime fechaLanzamiento;
        private double? preciAproxMercado;
        private int? numJugadores;
        private CategoriasDTO categoria;
        private GenerosDTO genero;

   

        public VideojuegosDTO()
        {
            this.IdVideojuego = 0;
            this.NombreVideojuego = "";
            this.FechaLanzamiento = DateTime.Now;
            this.PreciAproxMercado = 0.0;
            this.NumJugadores = 0;
        }
        public VideojuegosDTO(int idVideojuego, string nombreVideojuego, DateTime fechaLanzamiento, double preciAproxMercado, int numJugadores)
        {
            this.IdVideojuego = idVideojuego;
            this.NombreVideojuego = nombreVideojuego;
            this.FechaLanzamiento = fechaLanzamiento;
            this.PreciAproxMercado = preciAproxMercado;
            this.NumJugadores = numJugadores;
        }

        public int IdVideojuego { get => idVideojuego; set => idVideojuego = value; }
        public string NombreVideojuego { get => nombreVideojuego; set => nombreVideojuego = value; }
        public DateTime FechaLanzamiento { get => fechaLanzamiento; set => fechaLanzamiento = value; }
        public double? PreciAproxMercado { get => preciAproxMercado; set => preciAproxMercado = value; }
        public int? NumJugadores { get => numJugadores; set => numJugadores = value; }
        public CategoriasDTO Categoria { get => categoria; set => categoria = value; }
        public GenerosDTO Genero { get => genero; set => genero = value; }
    }
}
