package com.quanlythuvien.controller;

import com.quanlythuvien.entity.Book;
import com.quanlythuvien.entity.Employee;
import com.quanlythuvien.repository.BookRepository;
import com.quanlythuvien.repository.EmployeeRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class MainController implements Initializable {
    public Button btnSearchBook;
    public Button btnAddBook;
    public TextField txtfldSearchBook;
    public Button btnEditBook;
    public Button btnDeleteBook;
    public Button btnRefreshBooks;
    public TableView tableViewBooks;
    private ObservableList<Book> listBooks;

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

//    @PostConstruct
//    public void contruct() {
//        Book book = new Book("Việt Nam Sử Lược", "Lịch sử",
//                "Trần Trọng Kim", "Tri thức", "2006", "128978");
//        bookRepository.save(book);
//
//    }

    public MainController() {

    }

    // Is replaced with
//    @PostConstruct
//    void intialize() {
//        System.out.println("bbbbbbb");
//        List<Employee> list = employeeRepository.findAll();
//        System.out.println("here employee controller");
//        System.out.println(list);
//    }


    public void populateTableViewBooks() {
        //txtfldSearchBook.setText(Double.toString(btnAddBook.getHeight()));
        if (listBooks != null && listBooks.size() != 0) {
            listBooks.removeAll();
        }

        List<Book> books = bookRepository.findAll();
        listBooks = FXCollections.observableList(books);

        tableViewBooks.setItems(listBooks);
    }

    public void addSomeBooksToTableView(ActionEvent actionEvent) {
        listBooks.add(new Book() {
            {
                name = "Toi Tai Gioi";
                category = "Self-Help";
                author = "somebody";
                publisher = "tre";
                yearPublished = "2010";
            }
        });

        listBooks.add(new Book() {
            {
                name = "Cafe voi Tony";
                category = "Self-Help";
                author = "Tony BS";
                publisher = "tre";
                yearPublished = "2011";
            }
        });

        listBooks.add(new Book() {
            {
                name = "Freakonomics";
                category = "Kinh tế";
                author = "Levitt & Dubner";
                publisher = "Harper";
            }
        });

        listBooks.add(new Book() {
            {
                name = "Chủ nghĩa khắc kỷ";
                author = "William B. Irvine";
            }
        });
    }

    public void addNewBook(ActionEvent actionEvent) throws IOException {

        Book book = new Book("Việt Nam Sử Lược", "Lịch sử",
                "Trần Trọng Kim", "Tri thức", "2006", "128978");
        bookRepository.save(book);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        studentList = FXCollections.observableArrayList(
//                new Student(1, "Chau", "chau@gmail.com", 21),
//                new Student(2, "Chuong", "chuong@gmail.com", 20)
//        );
//        idColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("id"));
//        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
//        emailColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("email"));
//        ageColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("age"));
//        table.setItems(studentList);
    }
}
