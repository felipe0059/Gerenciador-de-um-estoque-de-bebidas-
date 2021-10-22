package one.digitalinnovation.beerstock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digitalinnovation.beerstock.dto.BeerDTO;
import one.digitalinnovation.beerstock.dto.QuantityDTO;
import one.digitalinnovation.beerstock.exception.BeerAlreadyRegisteredException;
import one.digitalinnovation.beerstock.exception.BeerNotFoundException;
import one.digitalinnovation.beerstock.exception.BeerStockExceededException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Api("Gerencie um depósito de bebidas.")
public interface BeerControllerDocs {

    @ApiOperation(value = "Adicionar bebida no estoque.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Bebida adicionada com sucesso."),
            @ApiResponse(code = 400, message = "Faltam campos na descrição ou quantidade negada pelo sistema.")
    })
    BeerDTO createBeer(BeerDTO beerDTO) throws BeerAlreadyRegisteredException;

    @ApiOperation(value = "Encontre uma bebida pelo nome.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Resultado de busca com o nome digitado."),
            @ApiResponse(code = 404, message = "Nome não retorna resultados.")
    })
    BeerDTO findByName(@PathVariable String name) throws BeerNotFoundException;

    @ApiOperation(value = "Relatório geral do estoque.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de todas as bebidas no sistema."),
    })
    List<BeerDTO> listBeers();

    @ApiOperation(value = "Deletar uma bebida pelo Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Bebida deletada com sucesso!"),
            @ApiResponse(code = 404, message = "Id não existe.")
    })
    void deleteById(@PathVariable Long id) throws BeerNotFoundException;
}
