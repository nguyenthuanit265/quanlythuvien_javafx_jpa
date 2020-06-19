package com.quanlythuvien.controller;

import com.quanlythuvien.QuanLyThuVienJavafxJpaApplication;
import com.quanlythuvien.entity.Book;
import com.quanlythuvien.entity.Employee;
import com.quanlythuvien.repository.BookRepository;
import com.quanlythuvien.repository.EmployeeRepository;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Controller
public class MainController implements Initializable {
    public TableColumn<Book, String> col_name;
    public TableColumn<Book, String> col_category;
    public TableColumn<Book, String> col_author;
    public TableColumn<Book, String> col_publisher;
    public TableColumn<Book, String> col_yearpublished;
    public TableColumn<Book, String> col_isbn;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private Button btnSearchBook;
    @FXML
    private Button btnAddBook;
    @FXML
    private TextField txtfldSearchBook;
    @FXML
    private Button btnEditBook;
    @FXML
    private Button btnDeleteBook;
    @FXML
    private Button btnRefreshBooks;
    @FXML
    private TableView<Book> tableViewBooks;

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

    /*public void addSomeBooksToTableView() {
        List<Book> templist = new ArrayList<>();

        Book newbook = new Book();
        newbook.setName("Toi Tai Gioi");
        newbook.setCategory("Self-Help");
        newbook.setAuthor("somebody");
        newbook.setPublisher("tre");
        newbook.setYearPublished("2010");
        templist.add(newbook);

        newbook = new Book();
        newbook.setName("Cafe voi Tony");
        newbook.setCategory("Self-Help");
        newbook.setAuthor("Tony BS");
        newbook.setPublisher("tre");
        newbook.setYearPublished("2011");
        templist.add(newbook);

        newbook = new Book();
        newbook.setName("Freakonomics");
        newbook.setCategory("Kinh tế");
        newbook.setAuthor("Levitt & Dubner");
        newbook.setPublisher("Harper");
        templist.add(newbook);

        newbook = new Book();
        newbook.setName("Chủ nghĩa khắc kỷ");
        newbook.setAuthor("William B. Irvine");
        templist.add(newbook);

        bookRepository.saveAll(templist);
    }*/

    public void addNewBook(ActionEvent actionEvent) throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/addbook.fxml"));
        Parent root = loader.load();
        dialog.setDialogPane((DialogPane) root);
        dialog.initOwner(mainBorderPane.getScene().getWindow());
//        dialog.initModality(Modality.WINDOW_MODAL);
//        dialog.setResizable(true);
        dialog.setTitle("Thêm 1 sách mới");

        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            AddBookController controller = loader.getController();
            Book book = controller.getNewAddedBook();
            bookRepository.save(book);
        }

        populateTableViewBooks();
    }

    public void editBook(ActionEvent actionEvent) {
//        ObservableList itemsDelete = tableViewBooks.getSelectionModel().getSelectedItems();
//        if (itemsDelete.isEmpty()) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Chỉnh sửa sách...");
//            alert.setHeaderText("Chọn ít nhất một cuốn sách để chỉnh sửa");
//            alert.initOwner(mainBorderPane.getScene().getWindow());
//            alert.showAndWait();
//            return;
//        }
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Xóa sách...");
//        alert.setResizable(false);
//        alert.setContentText("Bạn có chắc muốn xóa những sách đã chọn?");
//        alert.initOwner(mainBorderPane.getScene().getWindow());
//
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.isPresent() && result.get() == ButtonType.OK) {
//            bookRepository.deleteAll(itemsDelete);
//        }
//        populateTableViewBooks();
    }

    public void deleteBook(ActionEvent actionEvent) {
        ObservableList itemsDelete = tableViewBooks.getSelectionModel().getSelectedItems();
        if (itemsDelete.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Xóa sách...");
            alert.setHeaderText("Chọn ít nhất một cuốn sách để xóa");
            alert.initOwner(mainBorderPane.getScene().getWindow());
            alert.showAndWait();
            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Xóa sách...");
        alert.setResizable(false);
        alert.setContentText("Bạn có chắc muốn xóa những sách đã chọn?");
        alert.initOwner(mainBorderPane.getScene().getWindow());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            bookRepository.deleteAll(itemsDelete);
        }
        populateTableViewBooks();
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


    public void refreshBookList(ActionEvent actionEvent) {
        populateTableViewBooks();
    }

    public void clickMenuItemExit(ActionEvent actionEvent) {
        Stage mainStage = (Stage) mainBorderPane.getScene().getWindow();
        if (QuanLyThuVienJavafxJpaApplication.showClosingWindowDialog(mainStage)) {
            mainStage.close();
        }
    }

    public void onEditCommit(TableColumn.CellEditEvent<Book, String> bookStringCellEditEvent) {
        Book b = bookStringCellEditEvent.getRowValue();
        TableColumn<Book, String> column = bookStringCellEditEvent.getTableColumn();

        if (column.equals(col_name)) {
            b.setName(bookStringCellEditEvent.getNewValue());
        } else if (column.equals(col_category)) {
            b.setCategory(bookStringCellEditEvent.getNewValue());
        } else if (column.equals(col_author)) {
            b.setAuthor(bookStringCellEditEvent.getNewValue());
        } else if (column.equals(col_publisher)) {
            b.setPublisher(bookStringCellEditEvent.getNewValue());
        } else if (column.equals(col_yearpublished)) {
            b.setYearPublished(bookStringCellEditEvent.getNewValue());
        } else if (column.equals(col_isbn)) {
            b.setISBN(bookStringCellEditEvent.getNewValue());
        }

        bookRepository.updateBookInfo(b.getId(), b.getName(),
                b.getCategory(), b.getAuthor(), b.getPublisher(),
                b.getYearPublished(), b.getISBN());

        populateTableViewBooks();
    }

    public void showAboutDialog(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About...");
        alert.setResizable(false);
        alert.setHeaderText("Library Management - JavaFX + Spring Boot + JPA");
        alert.setContentText("Credits : Minh Thuan & Khanh Hoang");
        alert.initOwner(mainBorderPane.getScene().getWindow());
        alert.showAndWait();
    }
}
