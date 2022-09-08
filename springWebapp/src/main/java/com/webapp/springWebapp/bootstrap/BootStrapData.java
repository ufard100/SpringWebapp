package com.webapp.springWebapp.bootstrap;

import com.webapp.springWebapp.domain.Author;
import com.webapp.springWebapp.domain.Book;
import com.webapp.springWebapp.domain.Publisher;
import com.webapp.springWebapp.repositories.AuthorRepository;
import com.webapp.springWebapp.repositories.BookRepository;
import com.webapp.springWebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book book = new Book("Domain Driven Design","1");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        book.setPublisher(publisher);
        publisher.getBooks().add(book);



        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod","Johnson");
        Book book2 = new Book("J2EE Development without EJB","2");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);
        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());




    }
}
