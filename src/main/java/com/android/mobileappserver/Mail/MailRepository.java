package com.android.mobileappserver.Mail;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailModel, Long> {
}
