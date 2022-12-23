package com.godsonpeya.microblog.controller
import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PostController  @Autowired constructor(var postService: PostService) {
    @GetMapping("/posts")
    fun getPostList(): List<Post> {
        return postService.getPosts()
    }
    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id: Long): Post{
        return postService.getOne(id)
    }
    @PostMapping("/posts")
    fun createPost(@RequestBody post: Post): Post{
        return postService.savePost(post)
    }
    @PutMapping("/posts/{id}")
    fun updatePost(@PathVariable id: Long, @RequestBody post: Post): Post{
       return postService.updatePost(id,post)
    }
    @DeleteMapping("/posts/{id}")
    fun DeletePost(@PathVariable id: Long): String{
        return postService.deletePost(id)
    }


}