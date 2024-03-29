/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Services.SuKienService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import model.SuKien;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class QuanLySHController implements Initializable {

    private StageController sc = new StageController();
    private SuKienService SKService = new SuKienService();

    @FXML
    private Pane nhankhau_pane;
    @FXML
    private Pane quanlysh_pane;
    @FXML
    private Pane hokhau_pane;
    @FXML
    private Pane thongke_pane;
    @FXML
    private TextField event;
    @FXML
    private TextField place;
    @FXML
    private DatePicker time;
    @FXML
    private TextArea content;
    @FXML
    private Label check;
    @FXML
    private TableView<SuKien> sukien_table;
    @FXML
    private TableColumn<SuKien, String> event_col;
    @FXML
    private TableColumn<SuKien, String> place_col;
    @FXML
    private TableColumn<SuKien, String> time_col;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        phan_quyen();

        try {
            showSuKien();
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySHController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLySHController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void phan_quyen() {
        if (LoginController.user.getRole().equals("to_truong")) {
            quanlysh_pane.setVisible(false);
            quanlysh_pane.setManaged(false);
        }
        if (LoginController.user.getRole().equals("can_bo")) {
            hokhau_pane.setVisible(false);
            hokhau_pane.setManaged(false);

            nhankhau_pane.setVisible(false);
            nhankhau_pane.setManaged(false);

            thongke_pane.setVisible(false);
            thongke_pane.setManaged(false);
        }
    }

    @FXML
    void switchToTinhDiemScene(ActionEvent e) throws IOException {
        sc.switchToTinhDiemScene(e);
    }

    @FXML
    private void switchToHoKhauScene(ActionEvent e) throws IOException {
        sc.switchToHoKhauScene(e);
    }

    @FXML
    private void switchToNhanKhauScene(ActionEvent e) throws IOException {
        sc.switchToNhanKhauScene(e);
    }

    @FXML
    private void switchToTrangChuScene(ActionEvent e) throws IOException {
        sc.switchToTrangChuScene(e);
    }

    @FXML
    void switchToThongKeScene(ActionEvent e) throws IOException {
        sc.switchToThongKeScene(e);
    }

    @FXML
    public void handleExit() {
        sc.handleExit();
    }

    @FXML
    public void handleAddEvent() throws SQLException, ClassNotFoundException {
        String name = event.getText();
        String iplace = place.getText();
        LocalDate itime = time.getValue();
        String icontent = content.getText();

        if (icontent.equals("") || name.equals("") || iplace.equals("") || itime == null) {
            check.setText("Vui lòng nhập đầy đủ thông tin");
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-LL-dd");
            String convertTime = itime.format(formatter);
            SKService.ThemSuKien(name, iplace, icontent, convertTime, check);
            if (check.getText().contains("thành công")) {
                event.setText("");
                place.setText("");
                time.setValue(null);
                content.setText("");

                showSuKien();
            }
        }
    }

    @FXML
    public void showSuKien() throws SQLException, ClassNotFoundException {
        event_col.setCellValueFactory(new PropertyValueFactory<>("name"));

        place_col.setCellValueFactory(new PropertyValueFactory<>("place"));

        time_col.setCellValueFactory(new PropertyValueFactory<>("time"));

        sukien_table.setItems(SKService.getSuKien());
    }
}
