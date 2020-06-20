package com.quanlythuvien.repository;

import com.quanlythuvien.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
//    @Transactional
//    @Modifying
//    @Query("UPDATE Book SET name = :name, category = :category," +
//            "author = :author, publisher = :publisher, yearPublished = :yearPublished," +
//            "ISBN = :isbn WHERE id = :bookid")
//    int updateBookInfo(@Param("bookid") int bookid, @Param("name") String name,
//                       @Param("category") String category,
//                       @Param("author") String author,
//                       @Param("publisher") String publisher,
//                       @Param("yearPublished") String yearPublished,
//                       @Param("isbn") String isbn);
}
