using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBase.model
{
    public class CategoriasDTO
    {
        private string idCategoria;
        private string descripcionCategoria;
        public CategoriasDTO(string idCategoria, string descripcionCategoria)
        {
            this.IdCategoria = idCategoria;
            this.DescripcionCategoria = descripcionCategoria;
        }
        public CategoriasDTO()
        {
            this.IdCategoria = "";
            this.DescripcionCategoria = "";
        }
        public string IdCategoria { get => idCategoria; set => idCategoria = value; }
        public string DescripcionCategoria { get => descripcionCategoria; set => descripcionCategoria = value; }
    }
}
