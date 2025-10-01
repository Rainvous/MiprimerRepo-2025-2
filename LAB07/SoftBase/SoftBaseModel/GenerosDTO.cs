using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBase.model
{
    public class GenerosDTO
    {
        private int idGenero;
        private string descripcionGenero;

        public GenerosDTO(int idGenero, string descripcionGenero)
        {
            this.IdGenero = idGenero;
            this.DescripcionGenero = descripcionGenero;
        }
        public GenerosDTO()
        {
            this.IdGenero = 0;
            this.DescripcionGenero = "";
        }

        public int IdGenero { get => idGenero; set => idGenero = value; }
        public string DescripcionGenero { get => descripcionGenero; set => descripcionGenero = value; }
    }
}
