package com.android.mobileappserver.User;

import com.android.mobileappserver.Story.StoryModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel update(UserDTO user){
        UserModel userCreate = new UserModel(user.getLogin(), user.getEmail(), user.getPassword(), user.getPhoto());
        return userRepository.save(userCreate);
    }

    @Transactional
    public UserModel signIn(UserSignInDTO userSignInDTO){
        UserModel user = userRepository.findByLogin(userSignInDTO.getLogin());
        if(Objects.equals(user.getPassword(), userSignInDTO.getPassword())){
            return user;
        }
        return null;
    }

    @Transactional
    public UserModel signUp(UserDTO user){
        UserModel userCreate = new UserModel(user.getLogin(), user.getEmail(), user.getPassword(), user.getPhoto());
        return userRepository.save(userCreate);
    }

    @Transactional
    public List<StoryModel> getUserStories(Long id){
        UserModel user = userRepository.getReferenceById(id);
        return user.getStories();
    }

    @Transactional
    public UserModel getUserById(Long id){
        return userRepository.getReferenceById(id);
    }
}
