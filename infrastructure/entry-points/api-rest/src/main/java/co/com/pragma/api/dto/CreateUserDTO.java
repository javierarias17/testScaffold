package co.com.pragma.api.dto;

public record CreateUserDTO(String name, String lastName, Integer age, Integer idType, Long idNumber) {
}
