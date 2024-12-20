package application;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Table {

    public TableView<Mahasiswa> getTableView() {
        TableView<Mahasiswa> tabel = new TableView<>();

        TableColumn<Mahasiswa, String> kolomNim = new TableColumn<>("NIM");
        kolomNim.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> kolomNama = new TableColumn<>("Nama");
        kolomNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tabel.getColumns().addAll(kolomNim, kolomNama);

        tabel.getItems().addAll(
            new Mahasiswa(1, "2310817320007", "Zahra Nabila"),
            new Mahasiswa(2, "2210817220002", "Raudatul Sholehah"),
            new Mahasiswa(3, "2310817120010", "Nur Hikmah"),
            new Mahasiswa(4, "2310817120001", "Dina Izzati Elfadheya"),
            new Mahasiswa(5, "2310817220028", "Sheila Sabina"),
            new Mahasiswa(6, "2310817120014", "Aliya Raffa Naura Ayu"),
            new Mahasiswa(7, "2210817110002", "Muhammad Pasha Nabeel"),
            new Mahasiswa(8, "2310817210009", "Muhammad Ibnu Sina"),
            new Mahasiswa(9, "2310817310008", "Muhammad Rizki Ramadhan"),
            new Mahasiswa(10, "2210817110006", "Mohammad Zaki Firmansah")
        );

        return tabel;
    }
}
