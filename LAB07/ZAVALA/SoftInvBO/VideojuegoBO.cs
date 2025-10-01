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
    public class VideojuegoBO
    {
        private VideojuegoDAO videojuegoDao;

        public VideojuegoBO()
        {
            this.videojuegoDao = new VideojuegoDAOImpl();
        }

        public int Insertar(string descripciondescripcion_genero, int id)
        {
            SoftInvModel.VideoJuego videojuego = new SoftInvModel.VideoJuego
            {
                /*Descripcion_genero = descripciondescripcion_genero,
                Id_genero = id*/
            };
            return this.videojuegoDao.Insertar(videojuego);
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
