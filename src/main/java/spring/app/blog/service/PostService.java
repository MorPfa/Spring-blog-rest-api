package spring.app.blog.service;

import spring.app.blog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto post);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);
}
