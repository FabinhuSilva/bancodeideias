/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fabinhu
 */
public class propriedadesProjeto {
    public static void main(String[] args) {
        
        conexao.ConexaoBanco bd = new conexao.ConexaoBanco();
        //bd.conectar();
        
        String Local="127.0.0.1";
        String NomeBanco="banco";
        int Porta=5432;
        String caminho="jdbc:postgresql://"+Local+":"+Porta+"/"+NomeBanco;
        
        System.out.println(bd.getCaminho());
        System.out.println(caminho);
        System.out.println(bd.getDriver());
    }
    
}
