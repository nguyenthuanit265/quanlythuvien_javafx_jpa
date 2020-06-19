package com.quanlythuvien.controller;

import com.quanlythuvien.entity.Book;
import javafx.fxml.FXML;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;

public class AddBookController {
    @FXML
    private DialogPane addBookDialogPane;
    @FXML
    private TextField txtfldName;
    @FXML
    private TextField txtfldCategory;
    @FXML
    private TextField txtfldAuthor;
    @FXML
    private TextField txtfldPublisher;
    @FXML
    private TextField txtfldYearPublished;
    @FXML
    private TextField txtfldISBN;

    public DialogPane getAddBookDialogPane() {
        return addBookDialogPane;
    }

    public void setAddBookDialogPane(DialogPane addBookDialogPane) {
        this.addBookDialogPane = addBookDialogPane;
    }

    public TextField getTxtfldName() {
        return txtfldName;
    }

    public void setTxtfldName(TextField txtfldName) {
        this.txtfldName = txtfldName;
    }

    public TextField getTxtfldCategory() {
        return txtfldCategory;
    }

    public void setTxtfldCategory(TextField txtfldCategory) {
        this.txtfldCategory = txtfldCategory;
    }

    public TextField getTxtfldAuthor() {
        return txtfldAuthor;
    }

    public void setTxtfldAuthor(TextField txtfldAuthor) {
        this.txtfldAuthor = txtfldAuthor;
    }

    public TextField getTxtfldPublisher() {
        return txtfldPublisher;
    }

    public void setTxtfldPublisher(TextField txtfldPublisher) {
        this.txtfldPublisher = txtfldPublisher;
    }

    public TextField getTxtfldYearPublished() {
        return txtfldYearPublished;
    }

    public void setTxtfldYearPublished(TextField txtfldYearPublished) {
        this.txtfldYearPublished = txtfldYearPublished;
    }

    public TextField getTxtfldISBN() {
        return txtfldISBN;
    }

    public void setTxtfldISBN(TextField txtfldISBN) {
        this.txtfldISBN = txtfldISBN;
    }

    public Book getNewAddedBook() {
        String name = txtfldName.getText();
        String category = txtfldCategory.getText();
        String author = txtfldAuthor.getText();
        String publisher = txtfldPublisher.getText();
        String yearPublished = txtfldYearPublished.getText();
        String ISBN = txtfldISBN.getText();
        Book newbook = new Book(name, category, author, publisher, yearPublished, ISBN);
        return newbook;
    }
}
