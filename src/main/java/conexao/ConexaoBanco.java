package conexao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Fabinhu
 */
public class ConexaoBanco {

    
    public Statement stm; // Responsavel por preparar e realizar pesquisas no banco de dados;
    public ResultSet rs; // Responsavel por armazenar o resultado de um pesquisa passada para o statement;
    private String driver ;
    private String caminho;
    public Connection conexao; // Responsavel por realizar a conexão com o banco de dados;
    String Local;
    int porta;
    String NomeDoBanco;

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
            driver = "org.postgresql.Driver";
        }
    
        public String getCaminho() {
            return caminho;
        }

        public void setCaminho(String caminho, String Local, int Porta, String NomeBanco) {
           // this.caminho = caminho;
            Local= getLocal();
            Porta = getPorta();
            NomeBanco = getNomeDoBanco();
            this.caminho = "jdbc:postgresql://"+Local+":"+Porta+"/"+NomeBanco;
        }
    
    
    public String getLocal() {
            return Local;
        }

        public void setLocal(String Local) {
            this.Local = Local;
            Local = "127.0.0.1";
        }

        public int getPorta() {
            return porta;
        }

        public void setPorta(int porta) {
            this.porta = porta;
            porta = 5432;
            
        }

        public String getNomeDoBanco() {
            return NomeDoBanco;
        }

        public void setNomeDoBanco(String NomeDoBanco) {
            this.NomeDoBanco = NomeDoBanco;
            NomeDoBanco = "banco";
        }
    
    public void conectar() { // Metodo responsavel por realizar a conexão;
        try {
            System.setProperty("jdbc.Drivers", getDriver()); // Seta a propriedade do driver de conexão;
            conexao = DriverManager.getConnection(getCaminho()); // Realiza a conexão com o banco;
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void desconectar() { // Metodo responsavel por fechar a conexão
        try {
            conexao.close(); // Fechar conexão
            JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage(), "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    }
    
        

}
