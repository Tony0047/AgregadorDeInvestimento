package Tony.AgregadorDeInvestimento.controller;

public record UpdateUserDto(
    String username,
    String email,
    String password
) {
}
