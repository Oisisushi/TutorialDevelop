package com.techacademy.service;

import java.util.List;
import java.util.Set; // チャプター9で追加

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //チャプター7で追加

import com.techacademy.entity.User;
import com.techacademy.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    /** 全件を検索して返す */
    public List<User> getUserList(){
        // リポジトリのfindAllメソッドを呼び出す
        return userRepository.findAll();
    }

    // ---- チャプター8で追記ここから ----
    /** Userを一件検索して返す */
    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }
    // ---- チャプター8で追記ここまで ----

    // ---- チャプター7で追記ここから ----
    /** Userの登録を行う */
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    // ---- チャプター7で追記ここまで ----
    // ---- チャプター9追記ここから ----
    /** Userの削除を行う */
    @Transactional
    public void deleteUser(Set<Integer> idck) {
        for(Integer id : idck) {
            userRepository.deleteById(id);
        }
    }
    // ---- チャプター9追記ここまで ----

}
