package CiroVitiello.U5W2D2.controllers;

import CiroVitiello.U5W2D2.entities.Blog;
import CiroVitiello.U5W2D2.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    private List<Blog> getAllBlogs() {
        return this.blogService.getBlogList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Blog SaveBlog(@RequestBody Blog body) {
        return this.blogService.saveBlog(body);
    }

    @GetMapping("/{blogId}")
    private Blog findBlogById(@PathVariable int blogId) {
        return this.blogService.findById(blogId);
    }

    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody Blog body) {
        return this.blogService.findByIdAndUpdate(blogId, body);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findBlogByIdAndDelete(@PathVariable int blogId) {
        this.blogService.findByIdAndDelete(blogId);
    }

}
