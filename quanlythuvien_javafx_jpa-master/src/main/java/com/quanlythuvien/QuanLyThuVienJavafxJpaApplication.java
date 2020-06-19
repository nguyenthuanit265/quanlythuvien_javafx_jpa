package com.quanlythuvien;

import com.quanlythuvien.controller.MainController;
import com.quanlythuvien.repository.BookRepository;
import com.quanlythuvien.repository.EmployeeRepository;
import com.quanlythuvien.repository.UserAccountRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Optional;

@SpringBootApplication
public class QuanLyThuVienJavafxJpaApplication extends Application {

    private ConfigurableApplicationContext springContext;
    Parent root;
    FXMLLoader fxmlLoader = null;

    public static void main(String[] args) {
        launch(QuanLyThuVienJavafxJpaApplication.class, args);
    }

    @Override
    public void init() throws Exception {
        springContext = SpringApplication.run(QuanLyThuVienJavafxJpaApplication.class);
        springContext
                .getAutowireCapableBeanFactory()
                .autowireBeanProperties(
                        this,
                        AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,
                        true
                );
//        fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
//        fxmlLoader.setControllerFactory(springContext::getBean);
//        root = fxmlLoader.load();
        springContext.getBean(BookRepository.class);
        springContext.getBean(EmployeeRepository.class);
        springContext.getBean(UserAccountRepository.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
//                getResource("/main.fxml"));
//        root = fxmlLoader.load();
//        fxmlLoader.setControllerFactory(springContext::getBean);
        fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(720.0);
        primaryStage.setMinHeight(600.0);
        primaryStage.setTitle("Library Manager");
        primaryStage.setOnCloseRequest(e -> {
            if (!showClosingWindowDialog(primaryStage))
                e.consume();
        });
        primaryStage.show();

        MainController mainController = fxmlLoader.getController();
        mainController.populateTableViewBooks();
    }

    public static boolean showClosingWindowDialog(Stage stage) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exiting..");
        alert.setResizable(false);
        alert.setContentText("Are you sure you want to quit?");
        alert.initOwner(stage);

        Optional<ButtonType> result = alert.showAndWait();
        return (result.isPresent() && result.get() == ButtonType.OK);
    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

}
