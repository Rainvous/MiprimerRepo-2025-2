using SoftInvPersistance.DAO;
using SoftInvPersistance.DAOImpl.Util;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBO
{
    public class GeneroBO
    {
        private GeneroDAO generoDao;

        public GeneroBO()
        {
            this.generoDao = new GeneroDAOImpl();
        }

        public int Insertar(string descripciondescripcion_genero, int id)
        {
            SoftInvModel.Genero genero = new SoftInvModel.Genero
            {
                Descripcion_genero = descripciondescripcion_genero,
                Id_genero = id
            };
            return this.generoDao.Insertar(genero);
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
