package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/praktikum7";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection connect() throws Exception {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void addPelanggan(String nama, String email, String telepon) throws Exception {
        String query = "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addBuku(String judul, String penulis, double harga, int stok) throws Exception {
        String query = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addPenjualan(int jumlah, int total_harga, String tanggal) throws Exception {
        String query = "INSERT INTO Penjualan (jumlah, total_harga, tanggal) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, jumlah);
            stmt.setInt(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getPelanggan() throws Exception {
        String query = "SELECT * FROM Pelanggan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("nama") + ", " + rs.getString("email") + ", " + rs.getString("telepon"));
            }
        }
        return result;
    }

    public static List<String> getBuku() throws Exception {
        String query = "SELECT * FROM Buku";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("judul") + ", " + rs.getString("penulis") + ", " + rs.getDouble("harga") + ", " + rs.getInt("stok"));
            }
        }
        return result;
    }

    public static List<String> getPenjualan() throws Exception {
        String query = "SELECT * FROM Penjualan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getInt("jumlah") + ", " + rs.getInt("total_harga") + ", " + rs.getDate("tanggal"));
            }
        }
        return result;
    }

    public static void updatePelanggan(int id, String nama, String email, String telepon) throws Exception {
        String query = "UPDATE Pelanggan SET nama = ?, email = ?, telepon = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.setInt(4, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateBuku(int buku_id, String judul, String penulis, double harga, int stok) throws Exception {
        String query = "UPDATE Buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setDouble(3, harga);
            stmt.setInt(4, stok);
            stmt.setInt(5, buku_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePenjualan(int penjualan_id, int jumlah, int total_harga, String tanggal) throws Exception {
        String query = "UPDATE Penjualan SET jumlah = ?, total_harga = ?, tanggal = ? WHERE penjualan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, jumlah);
            stmt.setInt(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.setInt(4, penjualan_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePelanggan(int id) throws Exception {
        String query = "DELETE FROM Pelanggan WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBuku(int buku_id) throws Exception {
        String query = "DELETE FROM Buku WHERE buku_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, buku_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletePenjualan(int penjualan_id) throws Exception {
        String query = "DELETE FROM Penjualan WHERE penjualan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, penjualan_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
