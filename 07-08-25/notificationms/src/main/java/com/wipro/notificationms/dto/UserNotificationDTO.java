package com.wipro.notificationms.dto;
import lombok.Data;

@Data
public class UserNotificationDTO {
    private String username;
    private String password;
    private String address;
    private String action; 

}
