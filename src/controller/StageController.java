package controller;

import java.io.IOException;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.UserModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class StageController {
    private Stage stage;
    private Scene scene;
    
    @FXML
    public void switchToHoKhauScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/HoKhau.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToNhanKhauScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/NhanKhau.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToTrangChuScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/TrangChu.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
    
    @FXML
    public void switchToThongKeScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ThongKe.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
    @FXML
    public void switchToQLSinhHoatScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/QuanLySH.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
    
    @FXML
     void switchToThemNhanKhauScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ThemNhanKhau.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    void switchToThemHoKhauScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/ThemHoKhau.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
     @FXML
    void switchToTinhDiemScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/TinhDiem.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
    
   
    
    @FXML
    public void switchToDetailScene() throws IOException {
        FXMLLoader fl = new FXMLLoader(getClass().getResource("/view/ChiTietHoKhau.fxml"));
        Parent root1 = (Parent) fl.load();
        Stage stage1 = new Stage();
        stage1.setScene(new Scene(root1));
        stage1.show();
    }
    
    @FXML
    public void switchToDangNhapScene(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/DangNhap.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getStylesheets().add("/CSS/globalStyle.css");
        stage.setScene(scene);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);
        stage.show();
    }
    
    @FXML
    public void handleExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Comfirm?");
        alert.setHeaderText("Xác nhận!");
        alert.setContentText("Thoát chương trình?");
        alert.initStyle(StageStyle.UNDECORATED);
        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        alert.initModality(Modality.APPLICATION_MODAL);
        
//        DialogPane dialog = alert.getDialogPane();
//
//        dialog.getStylesheets().add(getClass().getResource("/CSS/globalStyle.css").toString());
//        dialog.getStyleClass().add("dialog");

        Optional<ButtonType> res =  alert.showAndWait();
        if (res.get() == buttonYes) {
            System.exit(0);
        }
    }
    
    @FXML
    public void handleLogout(ActionEvent e) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Xác nhận!");
        alert.setContentText("Bạn chắc chắn muốn đăng xuất?");
        alert.initStyle(StageStyle.UNDECORATED);
        ButtonType buttonYes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType buttonNo = new ButtonType("No", ButtonBar.ButtonData.NO);
        alert.getButtonTypes().setAll(buttonYes, buttonNo);
        alert.initModality(Modality.APPLICATION_MODAL);
        
        DialogPane dialog = alert.getDialogPane();
//
//        dialog.getStylesheets().add(getClass().getResource("/CSS/globalStyle.css").toString());
//        dialog.getStyleClass().add("dialog");
//        dialog.setEffect(new DropShadow(2d, 0d, +2d, Color.BLACK));


        Optional<ButtonType> res =  alert.showAndWait();
        if (res.get() == buttonYes) {
            switchToDangNhapScene(e);
            LoginController.user = new UserModel("", "");
        }
    }
    
}
