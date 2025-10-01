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
    public class CategoriaDAOImpl : DAOImplBase, CategoriaDAO
    {
        private CategoriasDTO categoria;
        //NOTA IMPORANTE: ESTE DAO ES PARA TABLAS QUE TIENEN UN ID AUTOGENERADO
        public CategoriaDAOImpl() : base("categoria") //PRIMERO NOMBRE DE LA TABLA
        {
            this.retornarLlavePrimaria = false;
            this.categoria = null;
            this.mostrarSentenciaSQL = true;
            // Configurar las columnas de la tabla
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("id_categoria", true, false));
            this.listaColumnas.Add(new Columna("descripcion_categoria", false, false));

        }
        //INICIO DEL ELIMINAR
        public int eliminar(CategoriasDTO categoria)
        {
            this.categoria = categoria;
            return base.Eliminar();
        }
        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@id_categoria", this.categoria.IdCategoria);
        }

        //FIN DEL ELIMINAR

        //COMO HACER EL INSERTAR
        protected override void IncluirValorDeParametrosParaInsercion()
        {
            //Sobreescribe el metodo de daoimplbase y agrega los parametros (en c# se usa @)
            //Recuerda que es autogenerado el id 
            AgregarParametro("@id_categoria", this.categoria.IdCategoria);
            AgregarParametro("@descripcion_categoria", this.categoria.DescripcionCategoria);
        }
        public int insertar(CategoriasDTO categoria) //ESTE ES EL INSERTAR DE LA INTERFAZ
        {
            this.categoria=categoria;
            return base.Insertar(); //ESTE ES EL INSERTAR DE LA CLASE PADRE (DAOImplBase)
        }
        //FIN DEL INSERTAR

        //INICIO DEL MODIFICAR
        public int modificar(CategoriasDTO categoria)
        {
            this.categoria = categoria;
            return base.Modificar();
        }

        protected override void IncluirValorDeParametrosParaModificacion()
        {
            AgregarParametro("@descripcion_categoria", this.categoria.DescripcionCategoria);
            AgregarParametro("@id_categoria", this.categoria.IdCategoria);
        }
        //FIN DEL MODIFICAR

        public CategoriasDTO obtenerPorId(string categoriaId)
        {
            this.categoria = new CategoriasDTO();
            this.categoria.IdCategoria = categoriaId;
            base.ObtenerPorId();
            return this.categoria;
        }
        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            //this.statement.setInt(1, this.almacen.getAlmacenId());
            AgregarParametro("@id_genero", this.categoria.IdCategoria);
        }

        public new BindingList<CategoriasDTO> ListarTodos()
        {
            BindingList<object> lista;
            lista = base.ListarTodos(); //llama al listar todos del daoimplbase
            BindingList<CategoriasDTO> retorno = new BindingList<CategoriasDTO>();
            foreach (CategoriasDTO obj in lista)
            {
                retorno.Add(obj);
            }
            return retorno;
        }
        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            //AQUI SE GUARDA EL OBJETO QUE SALE DE TU SELECT 
            this.categoria = new CategoriasDTO();
            this.categoria.IdCategoria = this.lector.GetString(0); //SOLO TIENE ID y STRING
            this.categoria.DescripcionCategoria = this.lector.GetString(1);
            //FUNCION QUE AYUDA A LISTAR Y OBTENER POR ID
        }
        protected override void LimpiarObjetoDelResultSet()
        {
            this.categoria = null;
        }
        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.categoria);
        }
    }
}
