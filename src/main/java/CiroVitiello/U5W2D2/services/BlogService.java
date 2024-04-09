package CiroVitiello.U5W2D2.services;

import CiroVitiello.U5W2D2.entities.Blog;
import CiroVitiello.U5W2D2.exceptions.NoFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {

    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> getBlogList() {
        return this.blogList;
    }

    public Blog saveBlog(Blog body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 1000));
        this.blogList.add(body);
        return body;
    }

    public Blog findById(int id) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) found = blog;

        }
        if (found == null) throw new NoFoundException(id);
        else return found;

    }

    public Blog findByIdAndUpdate(int id, Blog updatedBlog) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) found = blog;
            found.setCategory(updatedBlog.getCategory());
            found.setName(updatedBlog.getName());
            found.setCover(updatedBlog.getCover());
            found.setMinutesOfLecture(updatedBlog.getMinutesOfLecture());
            found.setContent(updatedBlog.getContent());
        }
        if (found == null) throw new NoFoundException(id);
        else return found;
    }

    public void findByIdAndDelete(int id) {
        Iterator<Blog> iterator = this.blogList.iterator();

        while (iterator.hasNext()) {
            Blog current = iterator.next();
            if (current.getId() == id) {
                iterator.remove();
            }
        }
        System.out.println("eliminated!");
    }
}
