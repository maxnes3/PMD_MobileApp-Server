package com.android.mobileappserver.User;

import com.android.mobileappserver.Story.StoryModel;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel update(UserDTO user){
        final UserModel currentUser = getUserById(user.getId());
        byte[] photoBytes = user.getPhoto() != null ? user.getPhoto().getBytes(StandardCharsets.UTF_8) : null;
        currentUser.setLogin(user.getLogin());
        currentUser.setEmail(user.getEmail());
        currentUser.setPassword(user.getPassword());
        currentUser.setPhoto(photoBytes);
        return userRepository.save(currentUser);
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
        byte[] photoBytes = user.getPhoto() != null ? user.getPhoto().getBytes(StandardCharsets.UTF_8) : null;
        UserModel userCreate = new UserModel(
                user.getLogin(),
                user.getEmail(),
                user.getPassword(),
                photoBytes);
        return userRepository.save(userCreate);
    }

    @Transactional
    public List<StoryModel> getUserStories(Long id){
        UserModel user = userRepository.getReferenceById(id);
        return user.getStories();
    }

    @Transactional
    public UserModel getUserById(Long id){
        final Optional<UserModel> user = userRepository.findById(id);
        return user.orElseThrow(() -> new UserNotFoundException(id));
    }

    @Transactional
    public List<UserModel> getAll(){
        return userRepository.findAll();
    }
}
