package com.example.sbd_tp2_intelij.servlets;

import com.example.sbd_tp2_intelij.DBConnection;
import com.example.sbd_tp2_intelij.Parque;
import com.example.sbd_tp2_intelij.tipoVeiculo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/Cliente")
public class Cliente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConnection dbConnection = new DBConnection();
        List<Parque> parques = dbConnection.procuraParques();
        List<tipoVeiculo> tiposVeiculos = dbConnection.procuraVeiculos();

        req.setAttribute("parques", parques);
        req.setAttribute("tiposVeiculos", tiposVeiculos);
        req.getRequestDispatcher("/cliente.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        String tipoVeiculo = null;
        if ("reservarVeiculo".equals(action)) {
            // Captura os dados do formulário
            tipoVeiculo = req.getParameter("tipoVeiculo");
            String parqueLevantamento = req.getParameter("parqueLevantamento");
            String inicio = req.getParameter("inicio");
            String fim = req.getParameter("fim");

        }


    }
}
