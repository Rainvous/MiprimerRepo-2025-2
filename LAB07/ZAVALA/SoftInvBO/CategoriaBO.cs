using SoftInvPersistance.DAO;
using SoftInvPersistance.DAOImpl;
using SoftInvPersistance.DAOImpl.Util;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBO
{
    public class CategoriaBO
    {
        private CategoriaDAO categoriaDAO;

        public CategoriaBO()
        {
            this.categoriaDAO = new CategoriaDAOImpl();
        }

        public int Insertar(string descripciondescripcion_categoria, int id)
        {
            SoftInvModel.Categoria categoria = new SoftInvModel.Categoria
            {
                Descripcion_categoria = descripciondescripcion_categoria,
                Id_categoria = id
            };
            return this.categoriaDAO.Insertar(categoria);
        }
        /*
        public int Modificar(string descripciondescripcion_genero, int id)
        {
            //
            return 1;
        }

        public int Eliminar(int id)
        {
            //
            return 1;
        }
        
        public SoftInvModel.GeneroDAO ObtenerPorId(int id)
        {
            //
            return SoftInvModel.GeneroDAO;
        }

        public BindingList<SoftInvModel.GeneroDAO> ListarTodos()
        {
            //
        }

        // Métodos adicionales de negocio
        public BindingList<SoftInvModel.GeneroDAO> BuscarPorDni(string dni)
        {
            //
        }

        public BindingList<SoftInvModel.GeneroDAO> BuscarPorNombre(string nombre)
        {
            //
        }
        */

    }
}
