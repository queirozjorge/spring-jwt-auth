package br.com.jorge.springjwtauth.models.request;

import javax.validation.constraints.NotNull;

public record UserCredentialsRequest(@NotNull String username, @NotNull String password) {
}
