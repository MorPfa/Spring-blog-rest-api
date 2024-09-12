package spring.app.blog.service.impl;

import org.springframework.stereotype.Service;
import spring.app.blog.entity.Post;
import spring.app.blog.exception.ResourceNotFoundException;
import spring.app.blog.payload.PostDto;
import spring.app.blog.repository.PostRepository;
import spring.app.blog.service.PostService;
import spring.app.blog.utils.PostMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {


    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post newPost = PostMapper.mapToPostEntity(postDto);
        postRepository.save(newPost);
        return PostMapper.mapToPostDto(newPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(PostMapper::mapToPostDto).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        return PostMapper.mapToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", id));
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post updatedPost = postRepository.save(post);
        return PostMapper.mapToPostDto(updatedPost);
    }
}
