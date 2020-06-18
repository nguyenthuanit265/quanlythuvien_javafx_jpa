package com.quanlythuvien.main;

import com.quanlythuvien.entity.Book;
import com.quanlythuvien.entity.Employee;
import com.quanlythuvien.entity.UserAccount;
import com.quanlythuvien.repository.BookRepository;
import com.quanlythuvien.repository.EmployeeRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Controller
public class MainController {
    public Button btnSearchBook;
    public Button btnAddBook;
    public TextField txtfldSearchBook;
    public Button btnEditBook;
    public Button btnDeleteBook;
    public Button btnRefreshBooks;
    public TableView tableViewBooks;

    public Button getBtnSearchBook() {
        return btnSearchBook;
    }

    public Button getBtnAddBook() {
        return btnAddBook;
    }

    public TextField getTxtfldSearchBook() {
        return txtfldSearchBook;
    }

    public Button getBtnEditBook() {
        return btnEditBook;
    }

    public Button getBtnDeleteBook() {
        return btnDeleteBook;
    }

    public Button getBtnRefreshBooks() {
        return btnRefreshBooks;
    }

    public TableView getTableViewBooks() {
        return tableViewBooks;
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    BookRepository bookRepository;

    private ConfigurableApplicationContext springContext;

    @FXML
    private StackPane stackPaneHolder;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    @FXML
    private Button btn_submit;

    @PostConstruct
    public void contruct() {
//        Book book = new Book("Việt Nam Sử Lược", "Lịch sử",
//                "Trần Trọng Kim", "Tri thức", "2006", "128978");
//        bookRepository.save(book);

    }

    public MainController() {

    }

    // Is replaced with
    @PostConstruct
    void intialize() {
        System.out.println("bbbbbbb");
        List<Employee> list = employeeRepository.findAll();
        System.out.println("here employee controller");
        System.out.println(list);
    }

    public void populateTableViewBooks() {
        //txtfldSearchBook.setText(Double.toString(btnAddBook.getHeight()));

        List<Book> bookObservableList = tableViewBooks.getItems();
        bookObservableList.add(new Book() {
            {
                name = "Freakonomics";
                category = "Kinh tế";
                author = "Levitt & Dubner";
                publisher = "Harper";
            }
        });
        bookObservableList.add(new Book(){
            {
                name = "Chủ nghĩa khắc kỷ";
                author = "William B. Irvine";
            }
        });

        //bookRepository.saveAll(bookObservableList);
    }

    public void addNewBook(ActionEvent actionEvent) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main.fxml"));
//        loader.setControllerFactory(springContext::getBean);
//        Node change = loader.load();
//        setPane(change);
        Book book = new Book("Việt Nam Sử Lược", "Lịch sử",
                "Trần Trọng Kim", "Tri thức", "2006", "128978");
        bookRepository.save(book);
//        bookRepository.saveAndFlush(book);
    }

    //Handles all events on mouse clicks and actions
//    private void eventHandler() {
//
//        btn_submit.setOnMouseClicked((MouseEvent event) -> {
//            Employee p = new Employee(1, "1", "1", "1", "1", "1");
//            employeeService.add(p);
//
//        });
//    }

    public void setPane(Node node) {
        if (stackPaneHolder.getChildren().isEmpty()) {
            //if stackPaneHolder is empty
            stackPaneHolder.getChildren().add(node);

        } else {
            if (stackPaneHolder.getClip() != node) {
                //if stackPaneHolder is not empty then remove existing layer and add new layer
                stackPaneHolder.getChildren().remove(0);
                stackPaneHolder.getChildren().add(0, node);
            }
        }
    }
}
