package com.example.sbd_tp2_intelij.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
    public static boolean gerirCliente(String dados, String[] array) { // Dados vai ser do tipo Manipula dados
// e gerirCliente vai retornar um boolean

        if (array == null || array.length < 10) {
            System.out.println("Dados inválidos");
            return false;
        }

// a verificacao se o NIF esta completo tem de ser feita na parte do jsp


        String query = "INSERT INTO Cliente (NIF, Nome, Contacto, Morada, Preferencias_Linguisticas)"
                + "VALUES('" + array[0] + "','" + array[1]+ "','" + array[2]+ "','" + array[3]+ "','" + array[4]+ "')"
                + "AS new ON DUPLICATE KEY UPDATE Nome = new.Nome, Contacto = new.Contacto,"
                + "    Morada = new.Morada,"
                + "    Preferencias_Linguisticas = new.Preferencias_Linguisticas;";
        /*boolean altera_dados = dados.xDiretiva(query)
         *
         *
         * if (altera_dados){
         * */


//TODO Ver aqui o array 6, porque depende se é empresa ou é pessoal
        String nQuery = "INSERT INTO Condutor(Numero_Carta,Nome,Data_Emissao_Carta,Data_Nascimento,Validade_Carta,Reputacao,NIF)"
                + "VALUES('"+ array[5] + "','"+ array[6] + "','"+ array[7] + "','"+ array[8] + "','"
                + array[9] + "','"+ array[10] + "','"+ array[0] + "') AS new"
                + "ON DUPLICATE KEY UPDATE"
                + "    Nome = new.Nome,\r\n"
                + "    Data_Emissao_Carta = new.Data_Emissao_Carta,"
                + "    Data_Nascimento = new.Data_Nascimento,"
                + "    Validade_Carta = new.Validade_Carta,"
                + "    Reputacao = new.Reputacao,"
                + "    NIF = new.NIF;";

        /* boolean altera_dados_n = dados.xDiretiva(nQuery)
         *
         * return altera_dados_n;
         * }
         *
         * return false
         *
         */



        return true; // alterar para "altera_dados"
    }

    public static boolean gerirCarro(String dados, String[] array) {
        // Validar se os dados de entrada são válidos
        if (array == null || array.length < 6) {
            System.out.println("Dados inválidos");
            return false;
        }

        // Construir a query SQL para inserir ou atualizar informações do veículo
        String query = "INSERT INTO Veiculo (Matricula, Marca, Modelo, Cor, Media, Tipo) "
                + "VALUES ('" + array[0] + "', '" + array[1] + "', '" + array[2] + "', '"
                + array[3] + "', '" + array[4] + "', '" + array[5] + "') "
                + "AS new "
                + "ON DUPLICATE KEY UPDATE "
                + "Marca = new.Marca, "
                + "Modelo = new.Modelo, "
                + "Cor = new.Cor, "
                + "Media = new.Media, "
                + "Tipo = new.Tipo;";

        // Executar a query usando um método similar ao `dados.xDiretiva(query)`
        // boolean alteraDados = dados.xDiretiva(query); // Aqui assume-se que `dados.xDiretiva` executa a query e retorna um booleano

        // Retornar o resultado da execução da query
        //return alteraDados;
        return true;
    }

}
