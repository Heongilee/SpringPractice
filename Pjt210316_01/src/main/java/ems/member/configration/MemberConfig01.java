package ems.member.configration;

import ems.member.dao.StudentDao;
import ems.member.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MemberConfig02.class, MemberConfig03.class})
public class MemberConfig01 {
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    @Bean
    public StudentRegisterService registerService() {
        return new StudentRegisterService(studentDao());
    }

    @Bean
    public StudentModifyService modifyService() {
        return new StudentModifyService(studentDao());
    }

    @Bean
    public StudentDeleteService deleteService() {
        return new StudentDeleteService(studentDao());
    }

    @Bean
    public StudentSelectService selectService() {
        return new StudentSelectService(studentDao());
    }

    @Bean
    public StudentAllSelectService allSelectService() {
        return new StudentAllSelectService(studentDao());
    }

}