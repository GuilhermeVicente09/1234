package com.example.sbd_tp2_intelij.servlets;

import com.example.sbd_tp2_intelij.DBConnection;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import java.io.IOException;

@WebServlet("/Admin")
public class Admin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if ("gerirCliente".equals(action)) {
            String nif = req.getParameter("nif");
            String nome = req.getParameter("nome");
            String contacto = req.getParameter("contacto");
            String morada = req.getParameter("morada");
            String preferencias = req.getParameter("preferenciasLinguisticas");

            // Chamar método que insere/atualiza na BD
            boolean ok = gerirCliente(nif, nome, contacto, morada, preferencias);
            if (ok) {
                // redirecionar ou forward para JSP de sucesso
                resp.sendRedirect("/adminSucesso.jsp");
            } else {
                // redirecionar ou forward para JSP de erro
                resp.sendRedirect("/adminErro.jsp");
            }
        }

        else if ("gerirCarro".equals(action)) {
            String matricula = req.getParameter("matricula");
            String marca = req.getParameter("marca");
            String modelo = req.getParameter("modelo");
            String cor = req.getParameter("cor");
            String media = req.getParameter("media"); // se fosse binário, precisaria de outra abordagem
            String tipo = req.getParameter("tipo");

            boolean ok = gerirCarro(matricula, marca, modelo, cor, media, tipo);
            if (ok) {
                resp.sendRedirect("/adminSucesso.jsp");
            } else {
                resp.sendRedirect("/adminErro.jsp");
            }
        }
    }

    // Exemplo de método auxiliar (aqui “inserir ou atualizar”)
    public boolean gerirCliente(String nif, String nome, String contacto,
                                String morada, String preferencias) {
        // Verificar se param estão OK
        if (nif == null || nif.length() < 9) return false;

        String query = "INSERT INTO Cliente (NIF, Nome, Contacto, Morada, Preferencias_Linguisticas) "
                + "VALUES (?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "  Nome = VALUES(Nome), "
                + "  Contacto = VALUES(Contacto), "
                + "  Morada = VALUES(Morada), "
                + "  Preferencias_Linguisticas = VALUES(Preferencias_Linguisticas)";

        try {
            // Abrir (ou reusar) a con
            DBConnection dbConn = new DBConnection();
            PreparedStatement ps = dbConn.con.prepareStatement(query);

            ps.setString(1, nif);
            ps.setString(2, nome);
            ps.setString(3, contacto);
            ps.setString(4, morada);
            ps.setString(5, preferencias);

            int rows = ps.executeUpdate();
            ps.close();
            return (rows > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean gerirCarro(String matricula, String marca, String modelo,
                              String cor, String media, String tipo) {
        String query = "INSERT INTO Veiculo (Matricula, Marca, Modelo, Cor, Media, Tipo) "
                + "VALUES (?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "  Marca = VALUES(Marca), "
                + "  Modelo = VALUES(Modelo), "
                + "  Cor = VALUES(Cor), "
                + "  Media = VALUES(Media), "
                + "  Tipo = VALUES(Tipo)";

        try {
            DBConnection dbConn = new DBConnection();
            PreparedStatement ps = dbConn.con.prepareStatement(query);
            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, cor);
            ps.setString(5, media); // se for binário, use ps.setBinaryStream(...) ou ps.setBytes(...)
            ps.setString(6, tipo);

            int rows = ps.executeUpdate();
            ps.close();
            return (rows > 0);

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
