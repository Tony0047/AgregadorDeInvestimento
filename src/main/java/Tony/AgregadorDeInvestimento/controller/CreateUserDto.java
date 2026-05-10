package Tony.AgregadorDeInvestimento.controller;

public record CreateUserDto(
    String username,
    String email,
    String password
) {
}
