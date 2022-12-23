package com.godsonpeya.microblog.service

import com.godsonpeya.microblog.entity.Post
import com.godsonpeya.microblog.entity.User
import com.godsonpeya.microblog.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(private var postRepository: PostRepository) {

    fun getPosts(): List<Post>{
        var posts = postRepository.findAll()
        return  posts
    }
    /*fun getOne(id: Long): Post{
            return postRepository.findById(id)
    }*/
    fun getOne(id: Long): Post =
        postRepository.findById(id).orElseThrow { IllegalArgumentException("Post with id = $id was not found")}
    fun savePost(post: Post): Post{
        if(post != null){
            return  postRepository.save(post)
        }
       return throw Exception("We can't save an empty post")
    }

    fun updatePost(id: Long ,postInput: Post): Post{
        val postToUpdate = getOne(id)
            postToUpdate.content = postInput.content
        return postRepository.save(postToUpdate)
    }
    fun deletePost(id:Long): String{
        val postToDelete = getOne(id)

        postRepository.delete(postToDelete)
        return "post deleted"
    }

}