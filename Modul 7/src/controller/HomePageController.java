package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import model.Buku;
import model.Database;
import model.Pelanggan;
import model.Penjualan;

public class HomePageController {

    @FXML
    private TableView<Pelanggan> tabelPelanggan;
    @FXML
    private TableColumn<Pelanggan, String> namaColumn;
    @FXML
    private TableColumn<Pelanggan, String> emailColumn;
    @FXML
    private TableColumn<Pelanggan, String> teleponColumn;
    @FXML
    private TextField namaField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField teleponField;
    @FXML
    private Button buttonAddPelanggan, buttonEditPelanggan, buttonDeletePelanggan;
    private ObservableList<Pelanggan> pelangganList;

    @FXML
    private TableView<Buku> tabelBuku;
    @FXML
    private TableColumn<Buku, String> judulColumn;
    @FXML
    private TableColumn<Buku, String> penulisColumn;
    @FXML
    private TableColumn<Buku, Integer> hargaColumn;
    @FXML
    private TableColumn<Buku, Integer> stokColumn;
    @FXML
    private TextField judulField, penulisField, hargaField, stokField;
    @FXML
    private Button buttonAddBuku, buttonEditBuku, buttonDeleteBuku;
    private ObservableList<Buku> bukuList;

    @FXML
    private TableView<Penjualan> tabelPenjualan;
    @FXML
    private TableColumn<Penjualan, Integer> jumlahColumn;
    @FXML
    private TableColumn<Penjualan, Integer> totalHargaColumn;
    @FXML
    private TableColumn<Penjualan, String> tanggalColumn;
    @FXML
    private TextField jumlahField, totalHargaField, tanggalField;
    @FXML
    private Button buttonAddPenjualan, buttonEditPenjualan, buttonDeletePenjualan;
    private ObservableList<Penjualan> penjualanList;
        
    public void initialize() {
        initializePelanggan();
        initializeBuku();
        initializePenjualan();
    }

    private void initializePelanggan() {
        namaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        teleponColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelepon()));
        loadDataPelanggan();
    }

    private void initializeBuku() {
        judulColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudul()));
        penulisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPenulis()));
        hargaColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHarga()).asObject());
        stokColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStok()).asObject());
        loadDataBuku();
    }

    private void initializePenjualan() {
        jumlahColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getJumlah()).asObject());
        totalHargaColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getTotalHarga()).asObject());
        tanggalColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTanggal()));
        loadDataPenjualan();
    }

    private void loadDataPelanggan() {
        pelangganList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM pelanggan")) {
            while (rs.next()) {
                pelangganList.add(new Pelanggan(rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelPelanggan.setItems(pelangganList);
    }

    private void loadDataBuku() {
        bukuList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM buku")) {
            while (rs.next()) {
                bukuList.add(new Buku(rs.getString("judul"), rs.getString("penulis"), rs.getInt("harga"), rs.getInt("stok")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelBuku.setItems(bukuList);
    }

    private void loadDataPenjualan() {
        penjualanList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM penjualan")) {
            while (rs.next()) {
                penjualanList.add(new Penjualan(
                    rs.getInt("jumlah"), 
                    rs.getInt("total_harga"), 
                    rs.getString("tanggal")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelPenjualan.setItems(penjualanList);
    }

    @FXML
    private void onAddPelanggan() {
        try {
            String nama = namaField.getText();
            String email = emailField.getText();
            String telepon = teleponField.getText();

            Database.addPelanggan(nama, email, telepon);

            loadDataPelanggan();

            clearFields();
            showAlert("Success", "Data added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add data: " + e.getMessage());
        }
    }

    @FXML
    private void onEditPelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Please select a customer to edit.");
                return;
            }

            String name = selectedPelanggan.getNama();
            String nama = namaField.getText();
            String email = emailField.getText();
            String telepon = teleponField.getText();

            if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
                showAlert("Warning", "All fields must be filled.");
                return;
            }

            Database.updatePelanggan(nama, email, telepon);

            selectedPelanggan.setNama(nama);
            selectedPelanggan.setEmail(email);
            selectedPelanggan.setTelepon(telepon);

            tabelPelanggan.refresh();
            clearFields();
            showAlert("Success", "Data updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update data: " + e.getMessage());
        }
    }

    @FXML
    private void onDeletePelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Please select a customer to delete.");
                return;
            }

            Database.deletePelanggan(String.valueOf(selectedPelanggan.getNama()));

            pelangganList.remove(selectedPelanggan);

            clearFields();
            showAlert("Success", "Data deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete data: " + e.getMessage());
        }
    }
    
    @FXML
    private void onAddBuku() {
        try {
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            int harga = Integer.parseInt(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            Database.addBuku(judul, penulis, harga, stok);

            bukuList.add(new Buku(judul, penulis, harga, stok)); 

            clearFields();
            showAlert("Success", "Data added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add data: " + e.getMessage());
        }
    }
    
    @FXML
    private void onEditBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Please select a book to edit.");
                return;
            }

            String judul = judulField.getText();
            String penulis = penulisField.getText();
            int harga = Integer.parseInt(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            if (judul.isEmpty() || penulis.isEmpty()) {
                showAlert("Warning", "All fields must be filled.");
                return;
            }

            Database.updateBuku(judul, penulis, harga, stok);

            selectedBuku.setJudul(judul);
            selectedBuku.setPenulis(penulis);
            selectedBuku.setHarga(harga);
            selectedBuku.setStok(stok);

            tabelBuku.refresh();
            clearFields();
            showAlert("Success", "Book data updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update book data: " + e.getMessage());
        }
    }

    @FXML
    private void onDeleteBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Please select a book to delete.");
                return;
            }

            Database.deleteBuku(String.valueOf(selectedBuku.getJudul()));

            bukuList.remove(selectedBuku);

            clearFields();
            showAlert("Success", "Book data deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete book data: " + e.getMessage());
        }
    }

    @FXML
    private void onAddPenjualan() {
        try {
            int jumlah = Integer.parseInt(jumlahField.getText());
            int totalHarga = Integer.parseInt(totalHargaField.getText());
            String tanggal = tanggalField.getText();

            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();

            if (selectedPelanggan == null || selectedBuku == null) {
                showAlert("Warning", "Please select both a customer and a book.");
                return;
            }

            String name = selectedPelanggan.getNama();
            String judul = selectedBuku.getJudul();

            Database.addPenjualan(jumlah, totalHarga, tanggal);

            penjualanList.add(new Penjualan(jumlah, totalHarga, tanggal));

            clearFields();
            showAlert("Success", "Data added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add data: " + e.getMessage());
        }
    }
    
    @FXML
    private void onEditPenjualan() {
        try {
            Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
            if (selectedPenjualan == null) {
                showAlert("Warning", "Please select a sale to edit.");
                return;
            }

            int penjualan = selectedPenjualan.getJumlah();
            int jumlah = Integer.parseInt(jumlahField.getText());
            int totalHarga = Integer.parseInt(totalHargaField.getText());
            String tanggal = tanggalField.getText();

            if (jumlah <= 0 || totalHarga <= 0 || tanggal.isEmpty()) {
                showAlert("Warning", "All fields must be filled and valid.");
                return;
            }

            Database.updatePenjualan(String.valueOf(penjualan), jumlah, totalHarga, String.valueOf(tanggal), String.valueOf(selectedPenjualan.getNama()), String.valueOf(((Buku) selectedPenjualan).getJudul()));

            selectedPenjualan.setJumlah(jumlah);
            selectedPenjualan.setTotalHarga(totalHarga);
            selectedPenjualan.setTanggal(tanggal);

            tabelPenjualan.refresh();
            clearFields();
            showAlert("Success", "Sale data updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update sale data: " + e.getMessage());
        }
    }

    @FXML
    private void onDeletePenjualan() {
        try {
            Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
            if (selectedPenjualan == null) {
                showAlert("Warning", "Please select a sale to delete.");
                return;
            }

            Database.deletePenjualan(String.valueOf(selectedPenjualan.getJumlah()));

            penjualanList.remove(selectedPenjualan);

            clearFields();
            showAlert("Success", "Sale data deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete sale data: " + e.getMessage());
        }
    }
    
    private void clearFields() {
        namaField.clear();
        emailField.clear();
        teleponField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }   
}