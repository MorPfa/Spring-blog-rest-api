package spring.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.app.blog.entity.Post;


public interface PostRepository extends JpaRepository<Post, Long> {

}
