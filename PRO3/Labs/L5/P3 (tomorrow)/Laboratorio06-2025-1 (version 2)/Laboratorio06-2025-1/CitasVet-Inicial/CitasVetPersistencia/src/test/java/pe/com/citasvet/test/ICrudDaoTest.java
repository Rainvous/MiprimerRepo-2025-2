package pe.com.citasvet.test;

// Defino que quiero probar
public interface ICrudDaoTest {
    void debeInsertar();
    void debeModificarSiIdExiste();
    void noDebeModificarSiIdNoExiste();
    void noDebeEliminarSiIdNoExiste();
    void debeEncontrarSiIdExiste();
    void noDebeEncontrarSiIdNoExiste();
    void debeListar();
    void debeEliminarSiIdExiste();
}