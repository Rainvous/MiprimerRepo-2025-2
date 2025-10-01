using SoftInv.DAOImpl.Util;
using SoftInv.DAOImpl;
using SoftInvModel;
using SoftInvPersistance.DAO;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace SoftInvPersistance.DAOImpl
{
    public class VideojuegoDAOImpl : DAOImplBase, VideojuegoDAO
    {
        private VideoJuego videojuego;

        public VideojuegoDAOImpl() : base("videojuego")
        {
            this.retornarLlavePrimaria = true;
            this.videojuego = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("id_genero", true, true));
            this.listaColumnas.Add(new Columna("_fid_genero", false, false));
            this.listaColumnas.Add(new Columna("_fid_categoria", false, false));
            this.listaColumnas.Add(new Columna("_nombre_videojuego", false, false));
            this.listaColumnas.Add(new Columna("_fecha_lanzamiento", false, false));
            this.listaColumnas.Add(new Columna("_precio_aprox_mercado", false, false));
            this.listaColumnas.Add(new Columna("_num_jugadores_mc", false, false));

        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {
            AgregarParametro("@_fid_genero", this.videojuego.Fid_genero);
            AgregarParametro("@_fid_categoria", this.videojuego.Fid_categoria);
            AgregarParametro("@_nombre_videojuego", this.videojuego.Nombre_videojuego);
            AgregarParametro("@_fecha_lanzamiento", this.videojuego.Fecha_lanzamiento);
            AgregarParametro("@_precio_aprox_mercado", this.videojuego.Precio_aprox_mercado);
            AgregarParametro("@_num_jugadores_mc", this.videojuego.Num_jugadores_mc);


        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@_fid_genero", this.videojuego.Fid_genero);
            AgregarParametro("@_fid_categoria", this.videojuego.Fid_categoria);
            AgregarParametro("@_nombre_videojuego", this.videojuego.Nombre_videojuego);
            AgregarParametro("@_fecha_lanzamiento", this.videojuego.Fecha_lanzamiento);
            AgregarParametro("@_precio_aprox_mercado", this.videojuego.Precio_aprox_mercado);
            AgregarParametro("@_num_jugadores_mc", this.videojuego.Num_jugadores_mc);
        }

        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@Id", this.videojuego.Id_videojuego);
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@Id", this.videojuego.Id_videojuego);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.videojuego = new VideoJuego
            {
                Id_videojuego = lector.GetInt32(0),
                Fid_genero = lector.GetInt32(1),
                Fid_categoria = lector.GetInt32(2),
                Nombre_videojuego = lector.GetString(3),
                Fecha_lanzamiento = lector.GetInt32(4),
                Precio_aprox_mercado = lector.GetInt32(5),
                Num_jugadores_mc = lector.GetInt32(6)
            };
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.videojuego = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.videojuego);
        }

        public int Insertar(VideoJuego videojuego)
        {
            this.videojuego = videojuego;
            return base.Insertar();
        }

        public int Modificar(VideoJuego videojuego)
        {
            this.videojuego = videojuego;
            return base.Modificar();
        }

        public int Eliminar(VideoJuego videojuego)
        {
            this.videojuego = videojuego;
            return base.Eliminar();
        }

        public VideoJuego ObtenerPorId(int id)
        {
            this.videojuego = new VideoJuego { Id_videojuego = id };
            base.ObtenerPorId();
            return this.videojuego;
        }

        public new BindingList<VideoJuego> ListarTodos()
        {
            BindingList<object> lista = base.ListarTodos();
            BindingList<VideoJuego> resultado = new BindingList<VideoJuego>();

            foreach (VideoJuego p in lista)
            {
                resultado.Add(p);
            }

            return resultado;
        }
    }
}
