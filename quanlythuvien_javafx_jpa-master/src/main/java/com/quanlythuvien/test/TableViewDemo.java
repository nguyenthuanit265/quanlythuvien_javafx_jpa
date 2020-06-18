package com.quanlythuvien.test;



import com.quanlythuvien.entity.Employee;
import com.quanlythuvien.entity.UserAccount;
import com.quanlythuvien.repository.UserAccountRepository;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

public class TableViewDemo extends Application {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public void start(Stage stage) {

        TableView<UserAccount> table = new TableView<UserAccount>();


        // Tạo cột UserName (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> userNameCol //
                = new TableColumn<UserAccount, String>("User Name");

        // Tạo cột Email (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> emailCol//
                = new TableColumn<UserAccount, String>("Email");

        // Tạo cột FullName (Kiểu dữ liệu String)
        TableColumn<UserAccount, String> fullNameCol//
                = new TableColumn<UserAccount, String>("Full Name");


        // Tạo 2 cột con cho cột FullName
        TableColumn<UserAccount, String> firstNameCol//
                = new TableColumn<UserAccount, String>("First Name");

        TableColumn<UserAccount, String> lastNameCol //
                = new TableColumn<UserAccount, String>("Last Name");

        // Thêm 2 cột con vào cột FullName
        fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);

        // Active Column
        TableColumn<UserAccount, Boolean> activeCol//
                = new TableColumn<UserAccount, Boolean>("Active");


        // Định nghĩa cách để lấy dữ liệu cho mỗi ô.
        // Lấy giá trị từ các thuộc tính của UserAccount.
        userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        activeCol.setCellValueFactory(new PropertyValueFactory<>("active"));


        // Sét xắp xếp theo userName
        userNameCol.setSortType(TableColumn.SortType.DESCENDING);
        lastNameCol.setSortable(false);


        // Hiển thị các dòng dữ liệu
        ObservableList<UserAccount> list = getUserList();
        table.setItems(list);

        table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);

        StackPane root = new StackPane();
        root.setPadding(new Insets(5));
        root.getChildren().add(table);

        stage.setTitle("TableView (o7planning.org)");

        Scene scene = new Scene(root, 450, 300);
        stage.setScene(scene);
        stage.show();
    }

    @PostConstruct
    @Override
    public void init() throws Exception {
        UserAccount userAccount = userAccountRepository.findById(1L).get();
        System.out.println(userAccount.toString());
    }

    private ObservableList<UserAccount> getUserList() {


        UserAccount user1 = new UserAccount(1L, "smith", "smith@gmail.com", //
                "Susan", "Smith", true);

        UserAccount user2 = new UserAccount(2L, "mcneil", "mcneil@gmail.com", //
                "Anne", "McNeil", true);
        UserAccount user3 = new UserAccount(3L, "white", "white@gmail.com", //
                "Kenvin", "White", false);

        ObservableList<UserAccount> list = FXCollections.observableArrayList(user1, user2, user3);

//        UserAccount userAccount = userAccountRepository.findById(1L).get();
//        ObservableList<UserAccount> list = FXCollections.observableArrayList(userAccount);
        return list;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
