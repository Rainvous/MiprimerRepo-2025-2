using SoftBase.DAOImpl.Util;
using SoftBase.model;
using SoftBasePersistance.DAO;
using SoftInv.DAOImpl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBasePersistance.DAOImpl
{
    public class VideojuegoDAOImpl : DAOImplBase, VideojuegoDAO
    {

        private VideojuegosDTO videojuego;
        //PRIMERO NOMBRE DE LA TABLA
        public VideojuegoDAOImpl() : base("videojuego")
        {

            this.retornarLlavePrimaria = true;
            this.videojuego = null;

        }
        protected override void ConfigurarListaDeColumnas()
        {
            // Configurar las columnas de la tabla "genero"
            this.listaColumnas.Add(new Columna("id_videojuego", true, true));
            this.listaColumnas.Add(new Columna("fid_genero", false, false));
            this.listaColumnas.Add(new Columna("fid_categoria", false, false));
            this.listaColumnas.Add(new Columna("nombre_videojuego", false, false));
            this.listaColumnas.Add(new Columna("fecha_lanzamiento", false, false));
            this.listaColumnas.Add(new Columna("precio_aprox_mercado", false, false));
            this.listaColumnas.Add(new Columna("num_jugadores_mc", false, false));
            // Agregar más columnas según la estructura de la tabla
        }
        protected override void IncluirValorDeParametrosParaInsercion()
        {
            //Sobreescribe el metodo de daoimplbase y agrega los parametros (en c# se usa @)
            //Recuerda que es autogenerado el id 
            System.Console.WriteLine("Fecha en insertar: "+this.videojuego.FechaLanzamiento);
            AgregarParametro("@fid_genero", this.videojuego.Genero.IdGenero);
            AgregarParametro("@fid_categoria", this.videojuego.Categoria.IdCategoria);
            AgregarParametro("@nombre_videojuego", this.videojuego.NombreVideojuego);
            var fecha= this.videojuego.FechaLanzamiento.Date;
            AgregarParametro("@fecha_lanzamiento", fecha);
            AgregarParametro("@precio_aprox_mercado", this.videojuego.PreciAproxMercado);
            AgregarParametro("@num_jugadores_mc", this.videojuego.NumJugadores);
        }
        public int insertar(VideojuegosDTO videojuego) //ESTE ES EL INSERTAR DE LA INTERFAZ
        {
            this.videojuego = videojuego;
            return base.Insertar(); //ESTE ES EL INSERTAR DE LA CLASE PADRE (DAOImplBase)
        }

        public VideojuegosDTO obtenerPorId(int videojuegoId)
        {
            this.videojuego = new VideojuegosDTO();
            this.videojuego.IdVideojuego = videojuegoId;
            base.ObtenerPorId();
            return this.videojuego;
        }
        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            //this.statement.setInt(1, this.almacen.getAlmacenId());
            AgregarParametro("@id_genero", this.videojuego.IdVideojuego);
        }

        public new BindingList<VideojuegosDTO> ListarTodos()
        {
            BindingList<object> lista;
            lista = base.ListarTodos(); //llama al listar todos del daoimplbase
            BindingList<VideojuegosDTO> retorno = new BindingList<VideojuegosDTO>();
            foreach (VideojuegosDTO obj in lista)
            {
                retorno.Add(obj);
            }
            return retorno;
        }

        public int modificar(VideojuegosDTO videojuego)
        {
            this.videojuego = videojuego;
            return base.Modificar();
        }
        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@fid_genero", this.videojuego.Genero.IdGenero);
            AgregarParametro("@fid_categoria", this.videojuego.Categoria.IdCategoria);
            AgregarParametro("@nombre_videojuego", this.videojuego.NombreVideojuego);
            AgregarParametro("@fecha_lanzamiento", this.videojuego.FechaLanzamiento);
            AgregarParametro("@precio_aprox_mercado", this.videojuego.PreciAproxMercado);
            AgregarParametro("@num_jugadores_mc", this.videojuego.NumJugadores);
            //ulimto el id
            AgregarParametro("@id_genero", this.videojuego.IdVideojuego);
        }

        public int eliminar(VideojuegosDTO videojuego)
        {
            this.videojuego = videojuego;
            return base.Eliminar();
        }
        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@id_genero", this.videojuego.IdVideojuego);
        }


    }
}
    
