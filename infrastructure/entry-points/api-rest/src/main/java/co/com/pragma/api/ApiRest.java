package co.com.pragma.api;
import co.com.pragma.api.dto.CreateUserDTO;
import co.com.pragma.api.dto.EditUserDTO;
import co.com.pragma.api.dto.UserDTO;
import co.com.pragma.api.mapper.UserDTOMapper;
import co.com.pragma.usecase.user.UserUseCase;
import co.com.pragma.usecase.user.inport.UserUseCaseInPort;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * API Rest controller.
 * 
 * Example of how to declare and use a use case:
 * <pre>
 * private final MyUseCase useCase;
 * 
 * public String commandName() {
 *     return useCase.execute();
 * }
 * </pre>
 */
@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {

    private final UserUseCaseInPort userUseCaseInPort;
    private final UserDTOMapper userMapper;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO createUserDTO) {
        userUseCaseInPort.saveUser(userMapper.toModel(createUserDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userMapper.toResponseList(userUseCaseInPort.getAllUsers()));
    }

    @GetMapping(path = "/{idNumber}")
    public ResponseEntity<UserDTO> getByIdNumber(@PathVariable(name = "idNumber") Long idNumber) {
        return ResponseEntity.ok(userMapper.toResponse(userUseCaseInPort.getUserByIdNumber(idNumber)));
    }

    @PutMapping
    public ResponseEntity<UserDTO> editUser(@RequestBody EditUserDTO user) {
        return ResponseEntity.ok(
                userMapper.toResponse(userUseCaseInPort.editUser(userMapper.toModel(user)))
        );
    }

    @DeleteMapping(path = "/{idNumber}")
    public ResponseEntity<Void> deleteUser(@PathVariable(name = "idNumber") Long idNumber) {
        userUseCaseInPort.deleteUser(idNumber);
        return ResponseEntity.ok().build();
    }
}
