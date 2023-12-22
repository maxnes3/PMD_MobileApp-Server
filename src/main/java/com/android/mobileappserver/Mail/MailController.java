package com.android.mobileappserver.Mail;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mail")
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService){
        this.mailService = mailService;
    }

    @PostMapping({"/create"})
    public MailDTO create(@RequestBody MailDTO mailDTO) {
        return new MailDTO(mailService.insert(mailDTO));
    }

    @PutMapping("/update/{id}")
    public MailDTO update(@PathVariable("id") Long id, @RequestBody MailDTO mailDTO){
        return new MailDTO(mailService.update(mailDTO));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception{
        mailService.delete(id);
    }

    @GetMapping("/get/{id}")
    public MailDTO get(@PathVariable("id") Long id){
        return new MailDTO(mailService.getById(id));
    }

    @GetMapping("/getAll")
    public List<MailDTO> getAll(@RequestParam("page") int page,
                                @RequestParam("size") int size) {
        return mailService.getAllMailPaged(page, size).stream().map(
                MailDTO::new
        ).toList();
    }
}
