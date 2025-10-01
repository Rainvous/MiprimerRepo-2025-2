using SoftBase.DAOImpl.Util;
using SoftBase.model;
using SoftBasePersistance.DAO;
using SoftInv.DAOImpl;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftBasePersistance.DAOImpl
{
    public class GeneroDAOImpl : DAOImplBase, GeneroDAO
    {
        private GenerosDTO genero;
        public GeneroDAOImpl() : base("genero") //PRIMERO NOMBRE DE LA TABLA
        {
            this.retornarLlavePrimaria = true;
            this.genero = null;
            // Configurar las columnas de la tabla
        }
        protected override void ConfigurarListaDeColumnas()
        {
            // Configurar las columnas de la tabla "genero"
            this.listaColumnas.Add(new Columna("id_genero", true, true));
            this.listaColumnas.Add(new Columna("descripcion_genero", false, false));
            // Agregar más columnas según la estructura de la tabla
        }
        //COMO HACER EL INSERTAR
        protected override void IncluirValorDeParametrosParaInsercion()
        {
            //Sobreescribe el metodo de daoimplbase y agrega los parametros (en c# se usa @)
            //Recuerda que es autogenerado el id 
            AgregarParametro("@descripcion_genero", this.genero.DescripcionGenero);
        }
        public int insertar(GenerosDTO genero) //ESTE ES EL INSERTAR DE LA INTERFAZ
        {
            this.genero = genero;
            return base.Insertar(); //ESTE ES EL INSERTAR DE LA CLASE PADRE (DAOImplBase)
        }
        //FIN DEL INSERTAR

        //INICIO DEL ELIMINAR
        public int eliminar(GenerosDTO genero)
        {
            this.genero=genero;
            return base.Eliminar();
        }
        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@id_genero", this.genero.IdGenero);
        }

        //FIN DEL ELIMINAR

        //INICIO DEL MODIFICAR
        public int modificar(GenerosDTO genero)
        {
            this.genero = genero;
            return base.Modificar();
        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@descripcion_genero", this.genero.DescripcionGenero);
            AgregarParametro("@id_genero", this.genero.IdGenero);
        }
        //FIN DEL MODIFICAR
        public GenerosDTO obtenerPorId(int generoId)
        {
            this.genero = new GenerosDTO();
            this.genero.IdGenero = generoId;
            base.ObtenerPorId();
            return this.genero;
        }
        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            //this.statement.setInt(1, this.almacen.getAlmacenId());
            AgregarParametro("@id_genero", this.genero.IdGenero);
        }
        //PARA LISTAR TODOS
        public new BindingList<GenerosDTO> ListarTodos() //listar todos de la interfaz
        {
            BindingList<object> lista;
            lista = base.ListarTodos(); //llama al listar todos del daoimplbase
            BindingList<GenerosDTO> retorno = new BindingList<GenerosDTO>();
            foreach (GenerosDTO obj in lista)
            {
                retorno.Add(obj);
            }
            return retorno;
        }
        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            //AQUI SE GUARDA EL OBJETO QUE SALE DE TU SELECT 
            this.genero = new GenerosDTO();
            this.genero.IdGenero = this.lector.GetInt32(0); //SOLO TIENE ID y STRING
            this.genero.DescripcionGenero = this.lector.GetString(1);
            //FUNCION QUE AYUDA A LISTAR Y OBTENER POR ID
        }
        protected override void LimpiarObjetoDelResultSet()
        {
            this.genero = null;
        }
        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.genero);
        }


    }
}
