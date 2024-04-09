package CiroVitiello.U5W2D2.services;

import CiroVitiello.U5W2D2.entities.Author;
import CiroVitiello.U5W2D2.exceptions.NoFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> getAuthorList() {
        return this.authorList;
    }

    public Author saveAuthor(Author body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 1000));
        body.setAvatar();
        this.authorList.add(body);
        return body;
    }

    public Author findById(int id) {
        Author found = null;
        for (Author blog : this.authorList) {
            if (blog.getId() == id) found = blog;

        }
        if (found == null) throw new NoFoundException(id);
        else return found;

    }

    public Author findByIdAndUpdate(int id, Author updatedAuthor) {
        Author found = findById(id);

        found.setName(updatedAuthor.getName());
        found.setEmail(updatedAuthor.getEmail());
        found.setSurname(updatedAuthor.getSurname());
        found.setBirthDate(updatedAuthor.getBirthDate());
        found.setAvatar();
        return found;
    }


    public void findByIdAndDelete(int id) {
        Iterator<Author> iterator = this.authorList.iterator();

        while (iterator.hasNext()) {
            Author current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
        System.out.println("eliminated!");
    }
}
