package com.android.mobileappserver.Mail;

import com.android.mobileappserver.User.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MailService {
    private final UserService userService;
    private final MailRepository mailRepository;

    public MailService(UserService userService, MailRepository mailRepository){
        this.userService = userService;
        this.mailRepository = mailRepository;
    }

    @Transactional
    public MailModel insert(MailDTO mailDTO) {
        var user = userService.getUserById(mailDTO.getUserId());
        MailModel mail = new MailModel(mailDTO.getMessage(), user);
        return mailRepository.save(mail);
    }

    @Transactional
    public MailModel update(MailDTO mailDTO){
        final MailModel mail = getById(mailDTO.getId());
        mail.setMessage(mailDTO.getMessage());
        return mailRepository.save(mail);
    }

    @Transactional
    public void delete(Long id) throws Exception{
        try{
            final MailModel curMail = getById(id);
            mailRepository.delete(curMail);
        }catch(Exception ex){
            throw new Exception("Ошибка при удалении mail с id: " + id);
        }

    }

    @Transactional
    public MailModel getById(Long id){
        return mailRepository.getReferenceById(id);
    }

    @Transactional
    public Page<MailModel> getAllMailPaged(int page, int size){
        return mailRepository.findAll(PageRequest.of(page - 1, size));
    }
}
