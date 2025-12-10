package br.com.feSchulz.controllers.docs;

import br.com.feSchulz.data.dto.PersonDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonControllerDocs {

    @Operation(summary = "Encontre todas as pessoas",
            description = "Encontre todas as pessoas",
            tags = {"pessoas"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = {@Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
                            )}
                    ),
                    @ApiResponse(
                            description = "Bad Request", responseCode = "400", content = @Content
                    ),
                    @ApiResponse(
                            description = "Unautorized", responseCode = "401", content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found", responseCode = "404", content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server error", responseCode = "500", content = @Content
                    )
            })
    List<PersonDTO> findAll();

    @Operation(summary = "Encontre uma pessoa especifica",
            description = "Encontre uma pessoa especifica pelo ID",
            tags = {"pessoas"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            description = "Bad Request", responseCode = "400", content = @Content
                    ),
                    @ApiResponse(
                            description = "Unautorized", responseCode = "401", content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found", responseCode = "404", content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server error", responseCode = "500", content = @Content
                    )
            })
    PersonDTO findById(@PathVariable("id") Long id);


    @Operation(summary = "Adicionar uma pessoa nova",
            description = "Adicionar uma pessoa nova",
            tags = {"pessoas"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            description = "Bad Request", responseCode = "400", content = @Content
                    ),
                    @ApiResponse(
                            description = "Unautorized", responseCode = "401", content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found", responseCode = "404", content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server error", responseCode = "500", content = @Content
                    )
            })
    PersonDTO create(@RequestBody PersonDTO person);


    @Operation(summary = "Atualizar uma pessoa especifica",
            description = "Atualizar uma pessoa especifica pelo ID",
            tags = {"pessoas"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            description = "Bad Request", responseCode = "400", content = @Content
                    ),
                    @ApiResponse(
                            description = "Unautorized", responseCode = "401", content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found", responseCode = "404", content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server error", responseCode = "500", content = @Content
                    )
            })
    PersonDTO update(@RequestBody PersonDTO person);

    @Operation(summary = "Remover uma pessoa especifica",
            description = "Remover uma pessoa especifica pelo ID",
            tags = {"pessoas"},
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content =
                            @Content(
                                    schema = @Schema(implementation = PersonDTO.class)
                            )
                    ),
                    @ApiResponse(
                            description = "Bad Request", responseCode = "400", content = @Content
                    ),
                    @ApiResponse(
                            description = "Unautorized", responseCode = "401", content = @Content
                    ),
                    @ApiResponse(
                            description = "Not Found", responseCode = "404", content = @Content
                    ),
                    @ApiResponse(
                            description = "Internal Server error", responseCode = "500", content = @Content
                    )
            })

    ResponseEntity<?> delete(@PathVariable("id") Long id);
}
