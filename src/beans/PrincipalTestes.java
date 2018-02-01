package beans;
 
import exceptions.Objectnotfound;
import exceptions.Objetojaexiste;
import negocios.Fachada;
 
public class PrincipalTestes {
 
    public static void main(String[] args) throws Objetojaexiste, Objectnotfound {
        // TODO Categoria
        // TODO Entregador
        // TODO Estoquista
        // TODO Filial
        // TODO Gerente
        // TODO JornadaDeTrabalho
        // TODO Marca
        // TODO Matriz
        // TODO NCM
        // TODO Produto_ref
        // TODO SubCategoria
        // TODO SupervisorEstoque
        // TODO Unidade
        /* Testing the class DBA */
       
        /* Creating objects of the type DBA */
       
        DBA dba1 = new DBA("12220933400" , "0001" , "0001", "23416393000114" , "2005-04-12" ,'F' ,
                "solteiro" ,"helo.12" , "123" , "1259312" ,"Heloisa Macedo de Souza",  "ativo" ,
                "Rua Eloy Monteiro Nunes" , "08133552321");
       
        DBA dba2 = new DBA ("12220933401" , "0002" , "0002", "23416393000166" , "2014-05-01" ,'M' ,
                "viúvo" ,"10082" , "122" , "1253312" ,"Aquiles Filho da Ninfa",  "inativo" ,
                "Rua Felipe Horta" , "08133552322");
       
        DBA dba3 = new DBA("12220933405" , "0003" , "0003", "23416353000166" , "2012-03-10" ,'M' ,
                "viúvo" ,"10085" , "125" , "1253312" ,"Marmoto Filho da Ninfa",  "inativo" ,
                "Rua Marmota" , "08133552332");
       
        /* Creating objects with the repository */
       
        Fachada.getInstancia().cadastrarFuncionario(dba1);
        Fachada.getInstancia().cadastrarFuncionario(dba2);
        Fachada.getInstancia().cadastrarFuncionario(dba3);
       
        /* Printing the objects */
       
        System.out.println("IMPRIMINDO FUNCIONARIOS CADASTRADOS");
        System.out.println(Fachada.getInstancia().listarFuncionarios());
       
        /* Testing the update function */
       
        Fachada.getInstancia().atualizarFuncionario(dba1);
        Fachada.getInstancia().atualizarFuncionario(dba2);
        Fachada.getInstancia().atualizarFuncionario(dba3);
        
      
       
        System.out.println("Removendo Funcionários  1 e 2.......");
       
        /* Testing the delete function */
       
        Fachada.getInstancia().removerFuncionario(dba1.getCpf());
        Fachada.getInstancia().removerFuncionario(dba2.getCpf());
       
        /* Apparently it doesn't work */
       
        System.out.println("PÓS DELETE");
        System.out.println(Fachada.getInstancia().listarFuncionarios());
       
   
       
 
       
        /* Creating objects of the type Fornecedor */
       
        Fornecedor f1 = new Fornecedor ("0001" , "Sadia" , "55274471000180" , "Rua valadares" ,
                "ipsep" , "54330315" , "Pernambuco" , "'8133115544'");
       
        Fornecedor f2 = new Fornecedor ("0002" , "Parmalat" , "15274471000180" , "Rua Amélia" ,
                "graças" , "54330311" , "Pernambuco" , "'8133115544'");
       
        Fornecedor f3 = new Fornecedor ("0003" , "Rexona" , "55274471900180" , "Rua 07" ,
                "várzea" , "54330310" , "Pernambuco" , "'8133115544'");
       
        /* Creating objects with the repository */
       
        Fachada.getInstancia().cadastrarFornecedor(f1);
        Fachada.getInstancia().cadastrarFornecedor(f2);
        Fachada.getInstancia().cadastrarFornecedor(f3);
       
        /* Printing the objects */
       
 
        System.out.println("IMPRIMINDO FORNECEDORES");
        System.out.println(Fachada.getInstancia().listarFornecedores());
       
        /* Updating the object F1 */
       
        f1.setBairro("Madalena");
        f1.setCep("50980380");
        f1.setRua("Rua Guerra");
 
       
        /* Testing the update function */
       
        System.out.println("\nAtualizando Fornecedor 1 .....\n");
        Fachada.getInstancia().atualizarFornecedor(f1);
        
        System.out.println("PÓS ATUALIZAÇÃO");
        System.out.println(Fachada.getInstancia().listarFornecedores());
       
        /* Testing the delete function */
       
        System.out.println("\nExcluindo Fornecedor 2 .....\n");
        System.out.println("\nExcluindo Fornecedor 3 .....\n");
        Fachada.getInstancia().removerFornecedor("0002");
        Fachada.getInstancia().removerFornecedor("0003");
       
       
        /* Printing after the update */

        System.out.println("PÓS DELETE");
        System.out.println(Fachada.getInstancia().listarFornecedores());
        
       
       
       
       
 
    }
 
}