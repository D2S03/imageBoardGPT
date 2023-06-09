package com.imageBoardAI.boardai.Services;

import com.imageBoardAI.boardai.DAO.PostRepository;
import com.imageBoardAI.boardai.Entety.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
private PostRepository postRepository;

@Autowired
public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
}


    public List<Post> getAllPosts() {
       List<Post> posts = postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
       return posts;
    }

    public void uploadPost(Post uploadPost) {
postRepository.save(uploadPost);
    }

    public void deletePost(int postID) {
Post post = postRepository.getReferenceById(postID);
postRepository.delete(post);
    }


    public Post findPostByID(int findID) {
    return postRepository.getReferenceById(findID);
    }
}
