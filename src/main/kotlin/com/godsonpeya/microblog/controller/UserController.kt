package com.godsonpeya.microblog.controller

import com.godsonpeya.microblog.entity.User
import com.godsonpeya.microblog.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class UserController @Autowired constructor(private val userService: UserService) {

    @GetMapping("/users")
    fun getUserList(): List<User> = userService.getUsers()

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Long): User = userService.getOne(id)

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): User = userService.saveUser(user)

    @PutMapping("/users/{id}")
    fun updateUser(@PathVariable id: Long,
                   @RequestBody user: User): User = userService.updateUser(id, user)

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Long): String = userService.deleteUser(id)
}