import commons.DaoFactory;
import dao.IBookDao;
import exception.DaoException;
import models.Book;


public class Main {

    public static void main(String[] args) throws DaoException {
        Book book = new Book();
        book.setId(1L);
        //Book book2 = new Book("Some fdata", "Interst book", 12.5F, "1-844223-455-2", 88, false);
        IBookDao dao = DaoFactory.getBookDao();
        for (Book b : dao.findAll())
            System.out.println(b);
//        for(Book b : dao.findAll())
//            System.out.println(b);
        //dao.update(book);
        //  dao.insert(book2);

    }
}