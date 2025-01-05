package com.example.sbd_tp2_intelij;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	public static java.sql.Connection con;

	static Statement stmt;

	static ResultSet rs;

	//	for how to set up data source see below.

	private static final String server="localhost:3306";
	private static final String database="MyRentACar";
	private static final String user="root";
	private static final String password="root";

	public static String DRV = "com.mysql.cj.jdbc.Driver";
	public static String URL = "jdbc:mysql://"+server+"/"+database+
			"?user="+user+"&password="+password+
			"&useLegacyDatetimeCode=false&serverTimezone=Europe/Lisbon";


	public DBConnection() {
		loadDriver();
		makeConnection();
	}

	static void loadDriver() {
		try {
			Class.forName(DRV);
			System.out.println("Load driver: "+DRV);
		} catch (ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
	}

	static void makeConnection() {
		try {
			con = DriverManager.getConnection(URL);
			System.out.println(con);
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Database connection: " + ex.getMessage());
			System.out.println();

		}
	}

	public List<tipoVeiculo> procuraVeiculos(){
		List<tipoVeiculo> tiposVeiculos = new ArrayList<>();
		String query = "SELECT Tipo, Descricao, Potencia, Numero_Portas, Numero_Lugares, Tipo_Motor, Capacidade_Carga FROM tipo_veiculo";
		try (Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				tiposVeiculos.add(new tipoVeiculo(
						rs.getString("Tipo"),
						rs.getString("Descricao"),
						rs.getInt("Potencia"),
						rs.getInt("Numero_Portas"),
						rs.getInt("Numero_Lugares"),
						rs.getString("Tipo_Motor"),
						rs.getInt("Capacidade_Carga")
				));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao procurar veiculos: " + ex.getMessage());
		}

		return tiposVeiculos;
	}
	public List<Parque> procuraParques() {
		List<Parque> parques = new ArrayList<>();
		String query = "SELECT Coordenadas, Morada, Localidade FROM parque_estacionamento";

		try (Statement stmt = con.createStatement();
			 ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				parques.add(new Parque(
						rs.getString("Coordenadas"),
						rs.getString("Morada"),
						rs.getString("Localidade")
				));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Erro ao procurar parques: " + ex.getMessage());
		}

		return parques;
	}

	public List<Aluguer> procuraAluguers() {
		List<Aluguer> aluguers = new ArrayList<>();
		String query = "SELECT ID_Aluguer, Inicio, Fim, Coordenadas_Recolha, Coordenadas_Entrega, Custo_Final, Desconto, Matricula, NIF FROM aluguer";
		//ResultSet rs = stmt.executeQuery();
        return aluguers;
    }

	public boolean reservarVeiculo(String tipoVeiculo, String parqueLevantamento, java.sql.Timestamp inicio, java.sql.Timestamp fim) {
		String query =
				"INSERT INTO Aluguer (ID_Aluguer, Inicio, Fim, Coordenadas_Recolha, Coordenadas_Entrega, Custo_Final, Matricula, NIF) " +
						"SELECT UUID(), ?, ?, ?, ?, 0, V.Matricula, '123456789' " +
						"FROM Veiculo V " +
						"WHERE V.Tipo = ? AND EXISTS ( " +
						"SELECT 1 FROM Parque_Estacionamento P WHERE P.Coordenadas = ? " +
						") " +
						"LIMIT 1";

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setTimestamp(1, inicio);
			stmt.setTimestamp(2, fim);
			stmt.setString(3, parqueLevantamento);
			stmt.setString(4, parqueLevantamento); // Mesmo parque para recolha e entrega
			stmt.setString(5, tipoVeiculo);
			stmt.setString(6, parqueLevantamento);

			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public double calcularCusto(String tipoVeiculo, java.sql.Timestamp inicio, java.sql.Timestamp fim) {
		String query = "SELECT tarifa_hora FROM tipo_veiculo WHERE Tipo = ?";
		double tarifaHora = 0;

		try (PreparedStatement stmt = con.prepareStatement(query)) {
			stmt.setString(1, tipoVeiculo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				tarifaHora = rs.getDouble("tarifa_hora");
			}

			long duracaoEmHoras = (fim.getTime() - inicio.getTime()) / (1000 * 60 * 60);
			return duracaoEmHoras * tarifaHora;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}


}