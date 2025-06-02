package library;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Library {
    public void addBook(Book book) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getYear());
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getInt("year")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void searchBook(int id) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE ID LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            boolean found = true;
            while (rs.next()) {
                found = true;
                System.out.println("ID: " + rs.getInt("id") +", Title: " + rs.getString("title") +
                        ", Author: " + rs.getString("author") + ", Year: " + rs.getInt("year"));
            }
            if (!found) {
                System.out.println("No books found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteBook(int id) {

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "DELETE FROM books WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}

