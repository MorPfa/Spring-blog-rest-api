package spring.app.blog.utils;

import spring.app.blog.entity.Post;
import spring.app.blog.payload.PostDto;

public class PostMapper {

    public static PostDto mapToPostDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getDescription(),
                post.getContent()
        );
    }

    public static Post mapToPostEntity(PostDto postDto) {
        return new Post(
                postDto.getId(),
                postDto.getTitle(),
                postDto.getDescription(),
                postDto.getContent()
        );
    }
}
