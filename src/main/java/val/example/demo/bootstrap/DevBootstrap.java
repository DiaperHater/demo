package val.example.demo.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import val.example.demo.model.Author;
import val.example.demo.model.Book;
import val.example.demo.model.Publisher;
import val.example.demo.repo.AuthorRepo;
import val.example.demo.repo.BookRepo;
import val.example.demo.repo.PublisherRepo;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepo authorRepo;
    private BookRepo bookRepo;
    private PublisherRepo publisherRepo;

    @Autowired
    public DevBootstrap(AuthorRepo authorRepo, BookRepo bookRepo, PublisherRepo publisherRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
        this.publisherRepo = publisherRepo;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        init();
    }

    private void init(){

        Publisher publisher = new Publisher("Valley pub. House");
        publisherRepo.save(publisher);


        //Andrew
        Author author = new Author("Andrew", "Tanenbaum");
        Book book = new Book("978-0132916523", "Structured Computer Organization (6th Edition)", publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);


        authorRepo.save(author);
        bookRepo.save(book);


        //Bjarne
        author = new Author("Bjarne", "Stroustrup");
        book = new Book(" 978-0321563842", "The C++ Programming Language, 4th Edition", publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepo.save(author);
        bookRepo.save(book);

    }
}
