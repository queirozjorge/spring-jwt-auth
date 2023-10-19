package br.com.jorge.springjwtauth.models.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public record UserRegisterRequest(@NotNull String username, @NotNull String password, @NotNull String role) {
}
