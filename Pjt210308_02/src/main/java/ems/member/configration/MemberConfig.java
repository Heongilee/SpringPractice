package ems.member.configration;

import ems.member.DataBaseConnectionInfo;
import ems.member.dao.StudentDao;
import ems.member.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class MemberConfig {
    //<bean id="studentDao" class="ems.member.dao.StudentDao" ></bean>
    @Bean
    public StudentDao studentDao() {
        return new StudentDao();
    }

    /*
    <bean id="registerService" class="ems.member.service.StudentRegisterService">
    <constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
	*/
    @Bean
    public StudentRegisterService registerService() {
        return new StudentRegisterService(studentDao());
    }

    /*
    <bean id="modifyService" class="ems.member.service.StudentModifyService">
    <constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
     */
    @Bean
    public StudentModifyService modifyService() {
        return new StudentModifyService(studentDao());
    }

    /*
	<bean id="deleteService" class="ems.member.service.StudentDeleteService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
     */
    @Bean
    public StudentDeleteService deleteService() {
        return new StudentDeleteService(studentDao());
    }

    /*
	<bean id="selectService" class="ems.member.service.StudentSelectService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
     */
    @Bean
    public StudentSelectService selectService() {
        return new StudentSelectService(studentDao());
    }

    /*
	<bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
		<constructor-arg ref="studentDao" ></constructor-arg>
	</bean>
     */
    @Bean
    public StudentAllSelectService allSelectService() {
        return new StudentAllSelectService(studentDao());
    }

    /*
	<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:xe" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>
     */
    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoDev() {
        DataBaseConnectionInfo infoDev = new DataBaseConnectionInfo();
        infoDev.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        infoDev.setUserId("scott");
        infoDev.setUserPw("tiger");

        return infoDev;
    }

    /*
	<bean id="dataBaseConnectionInfoReal" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@192.168.0.1:1521:xe" />
		<property name="userId" value="masterid" />
		<property name="userPw" value="masterpw" />
	</bean>
     */
    @Bean
    public DataBaseConnectionInfo dataBaseConnectionInfoReal() {
        DataBaseConnectionInfo infoReal = new DataBaseConnectionInfo();
        infoReal.setJdbcUrl("jdbc:oracle:thin:@192.168.0.1:1521:xe");
        infoReal.setUserId("masterid");
        infoReal.setUserPw("masterpw");

        return infoReal;
    }

    /*
	<bean id="informationService" class="ems.member.service.EMSInformationService">
		<property name="info">
			<value>Education Management System program was developed in 2015.</value>
		</property>
		<property name="copyRight">
			<value>COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.</value>
		</property>
		<property name="ver">
			<value>The version is 1.0</value>
		</property>
		<property name="sYear">
			<value>2015</value>
		</property>
		<property name="sMonth">
			<value>1</value>
		</property>
		<property name="sDay">
			<value>1</value>
		</property>
		<property name="eYear" value="2015" />
		<property name="eMonth" value="2" />
		<property name="eDay" value="28" />
		<property name="developers">
			<list>
				<value>Cheney.</value>
				<value>Eloy.</value>
				<value>Jasper.</value>
				<value>Dillon.</value>
				<value>Kian.</value>
			</list>
		</property>
		<property name="administrators">
			<map>
				<entry>
					<key>
						<value>Cheney</value>
					</key>
					<value>cheney@springPjt.org</value>
				</entry>
				<entry>
					<key>
						<value>Jasper</value>
					</key>
					<value>jasper@springPjt.org</value>
				</entry>
			</map>
		</property>
		<property name="dbInfos">
			<map>
				<entry>
					<key>
						<value>dev</value>
					</key>
					<ref bean="dataBaseConnectionInfoDev"/>
				</entry>
				<entry>
					<key>
						<value>real</value>
					</key>
					<ref bean="dataBaseConnectionInfoReal"/>
				</entry>
			</map>
		</property>
	</bean>
     */
    @Bean
    public EMSInformationService informationService() {
        EMSInformationService info = new EMSInformationService();
        info.setInfo("Education Management System program was developed in 2015.");
        info.setCopyRight("COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.");
        info.setVer("The version is 1.0");
        info.setsYear(2015);
        info.setsMonth(1);
        info.setsDay(1);
        info.seteYear(2015);
        info.seteMonth(2);
        info.seteDay(28);

        String[] data = {"Cheney.", "Eloy.", "Jasper.", "Dillon.", "Kian."};
        ArrayList<String> developers = new ArrayList<String>(Arrays.asList(data));
        info.setDevelopers(developers);

        Map<String, String> administrators = new HashMap<String, String>(){{
            put("Cheney", "cheney@springPjt.org");
            put("Jasper", "jasper@springPjt.org");
        }};
        info.setAdministrators(administrators);

        Map<String, DataBaseConnectionInfo> dbInfos = new HashMap<String, DataBaseConnectionInfo>(){{
            put("dev", dataBaseConnectionInfoDev());
            put("real", dataBaseConnectionInfoReal());
        }};
        info.setDbInfos(dbInfos);

        return info;
    }
}