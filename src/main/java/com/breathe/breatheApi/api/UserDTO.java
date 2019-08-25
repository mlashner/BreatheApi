package com.breathe.breatheApi.api;

import com.breathe.breatheApi.core.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("installationId")
    public String installationId;

    @JsonProperty("email")
    public String email;

    @JsonProperty("fullName")
    public String fullName;

    @JsonProperty("isAdmin")
    public boolean isAdmin;

    public User convertToUser() {
        return User.builder()
                .installationId(installationId)
                .email(email)
                .fullName(fullName)
                .build();
    }

    public static UserDTO convertUserToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        return UserDTO.builder()
                .id(user.getId())
                .installationId(user.getInstallationId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .isAdmin(user.getAdmin() != null)
                .build();
    }
}
