package com.quanlythuvien;

import com.quanlythuvien.main.MainController;
import com.quanlythuvien.repository.BookRepository;
import com.quanlythuvien.repository.EmployeeRepository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class QuanLyThuVienJavafxJpaApplication extends Application {
    private ConfigurableApplicationContext springContext;
    private Parent root;

    //    public static void main(String[] args) {
    //        SpringApplication.run(QuanLyThuVienJavafxJpaApplication.class, args);
    //        Application.launch(Main.class, args);
    //    }

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
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
        springContext.getBean(BookRepository.class);
        springContext.getBean(EmployeeRepository.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().
//                getResource("/main.fxml"));
//        root = fxmlLoader.load();
//        fxmlLoader.setControllerFactory(springContext::getBean);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(560.0);
        primaryStage.setMinHeight(720.0);
        primaryStage.show();

//        MainController mainController = fxmlLoader.getController();
//        mainController.populateTableViewBooks();

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }

}
