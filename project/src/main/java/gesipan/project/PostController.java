package gesipan.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }
    @GetMapping("/api/post/count")
    public Long countPosts(){
        Long count = postService.countAllPosts();
        return count;
    }

    @GetMapping("/api/posts")
    public List<Post> getPostByPage(@RequestParam int page, @RequestParam int pageSize){
        List<Post> posts = postService.findPostByPage(page,pageSize);

        return posts;
    }

    @GetMapping("/api/post/create")
    public void postData(@RequestParam String author, @RequestParam String title, @RequestParam String content){
        Post post = new Post();
        post.setTitle(title);
        post.setAuthor(author);
        post.setContent(content);
        postService.saveData(post);
    }

    @GetMapping("/api/post/update")
    public void updateData(@RequestParam Long id, @RequestParam String author, @RequestParam String title, @RequestParam String content){
        Post post = new Post();
        post.setId(id);
        post.setTitle(title);
        post.setAuthor(author);
        post.setContent(content);
        postService.delete(id);
        postService.saveData(post);
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.ok("게시물이 삭제되었습니다.");
    }

    @GetMapping("/post/detail/{id}")
    public ResponseEntity<?> detailPost(@PathVariable Long id){
        Post post = postService.getPost(id);
        return ResponseEntity.ok(post);
    }
}
