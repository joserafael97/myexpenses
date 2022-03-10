package br.com.jrafael.myexpenses.controller

import br.com.jrafael.myexpenses.common.extension.toDto
import br.com.jrafael.myexpenses.common.extension.toEntity
import br.com.jrafael.myexpenses.controller.dto.SpentDto
import br.com.jrafael.myexpenses.domain.repository.SpentRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/v1/api/spending")
class SpentController(private val spentRepository: SpentRepository) {
    @GetMapping
    fun get(): List<SpentDto> {
        val spending = spentRepository.findAll()
        return spending.map {
            it.toDto()
        }
    }

    @PostMapping
    fun add(@Valid @RequestBody spentDto: SpentDto): ResponseEntity<SpentDto> =
        ResponseEntity.ok(spentRepository.save(spentDto.toEntity()).toDto())

    @GetMapping("/{id}")
    fun getById(@PathVariable(value="id") id: Long): ResponseEntity<SpentDto> =
        spentRepository.findById(id).map { ResponseEntity.ok(it.toDto()) }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun updateById(@PathVariable(value = "id") id: Long, @Valid @RequestBody dto: SpentDto): ResponseEntity<SpentDto> =
        spentRepository.findById(id).map {
            val updated = it.copy(
                name = dto.name,
                description = dto.description
            )
            ResponseEntity.ok(spentRepository.save(updated).toDto())
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable(value = "id") id: Long): ResponseEntity<Void> =
        spentRepository.findById(id).map { spent ->
            spentRepository.delete(spent)
            ResponseEntity<Void>(HttpStatus.ACCEPTED)
        }.orElse(ResponseEntity.notFound().build())
}