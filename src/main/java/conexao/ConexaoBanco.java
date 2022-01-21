package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.
public class conexaoBanco{

    public conexaoBanco() {
       
    }
    
    String driver = "org.postgresql.Driver";
    String usuario = "postgres";
    String senha = "postgres";
    String url = "jdbc:";
    String banco = "postgresql";
    int porta = 5432;
    String enderecoBanco = "127.0.0.1";
    String nomeBanco = "banco";
    String urlBanco = getUrl()+getBanco()+"://"+getEnderecoBanco()+":"+getPorta()+"/"+getNomeBanco();
    Connection conexao;

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
   
    public String getUrlBanco() {
        return urlBanco;
    }

    public void setUrlBanco(String urlBanco) {
        this.urlBanco = urlBanco;
    }
    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public String getEnderecoBanco() {
        return enderecoBanco;
    }

    public void setEnderecoBanco(String enderecoBanco) {
        this.enderecoBanco = enderecoBanco;
    }
    
    /*
    ------------------------------------------------
      Crianto metodos Conectar() e Desconectar()
     ------------------------------------------------
    */
    
    public void conectarBanco() throws SQLException{
    
        try {
        //carregango Driver JDBC    
        Class.forName(getDriver());
        
        
        //conexao = (Connection) DriverManager.getConnection(getUrlBanco(),getUrl(),getNomeBanco());
        setConexao(DriverManager.getConnection(getUrlBanco(),getUsuario(),getSenha()));
        JOptionPane.showMessageDialog(null, "Banco Conectado com Sucesso ");
        } 
        catch (ClassNotFoundException ex)
        {
            System.err.print(ex.getMessage());
            JOptionPane.showMessageDialog(null, " Class Not Found Problema de Conexão com o Banco: "+ex);
        }
        catch (SQLException e){
            System.err.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "SQl Exception Problema de Conexão com o Banco: "+e);
        }
    }
}