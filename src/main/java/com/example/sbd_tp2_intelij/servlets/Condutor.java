package com.example.sbd_tp2_intelij.servlets;

import com.example.sbd_tp2_intelij.Aluguer;
import com.example.sbd_tp2_intelij.DBConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Condutor")
public class Condutor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        List<Aluguer> aluguer = dbConnection.procuraAluguers();
        req.setAttribute("<aluguer>", aluguer);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("levantar".equals(action)) {
            String idAluguer = req.getParameter("idAluguer");
            // Lógica para marcar que o condutor vai levantar o veículo
            // ...
            resp.sendRedirect("/Condutor?msg=okLevantar");
        } else if ("entregar".equals(action)) {
            String idAluguer = req.getParameter("idAluguer");
            // Lógica para “fechar” o aluguer, atribuir lugar, etc.
            // ...
            resp.sendRedirect("/Condutor?msg=okEntregar");
        }

    }
}
